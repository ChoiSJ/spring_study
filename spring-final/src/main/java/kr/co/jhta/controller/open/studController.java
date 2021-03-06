package kr.co.jhta.controller.open;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.service.openlecture.OpenLectureService;
import kr.co.jhta.vo.LectureEvaluationSheet;
import kr.co.jhta.vo.LectureRatingSave;
import kr.co.jhta.vo.stu.Student;

@Controller
@RequestMapping("/stud")
public class studController {
	
	@Autowired
	private OpenLectureService lectureservice;
	
	
	//성적 전에 보여주는 
	//강의 평가 화면 보여 주기
	//URL에 붙인 값 가져오기
	@RequestMapping(value="/lecturerating.do", method=RequestMethod.GET)
	public String lectureRating(@RequestParam int subjectNo, Model model){
		
		
		LectureEvaluationSheet register = lectureservice.getInvestListRegister(subjectNo);
		
		if(register.getRegister().equals("y")){
			
			List<LectureEvaluationSheet> sheet = lectureservice.getInvestListDeatil(subjectNo);
			
			model.addAttribute("detailsheet",sheet);
			
			return "openlecture/rating";
			
		}else{
			
			return"openlecture/ratingerror";
		}
			
	}

	//강의 평가 점수 등록
	@RequestMapping("ratingInsert.do")
	public String ratingInsert(int scoreNo, HttpServletRequest request, HttpSession session) {
		
		//로그인 유저 아이디 알아내기
		Student student = (Student)session.getAttribute("LOGIN_USER");
		
		List<String> rating = new ArrayList<String>();
		
		System.out.println("값값:"+scoreNo);
		
		//라디오 버튼 value값 알아내기
		Enumeration<String> parameterNames = request.getParameterNames();
		
		while (parameterNames.hasMoreElements()) {
			
			String ratingName = parameterNames.nextElement();
			
			if (ratingName.startsWith("appraise")) {
				
				String ratingValue = request.getParameter(ratingName);
				rating.add(ratingValue);
			}
			
		}
		
		for (String ratingScore : rating) {
			
			LectureRatingSave ratings = new LectureRatingSave();
			ratings.setRatingScore(Integer.parseInt(ratingScore));
			
			ratings.setStudentId(student.getId());
			ratings.setScoreNo(scoreNo);
			int i = 1;
			ratings.setInvestSubject(i);
			
			i= i++;
			
			lectureservice.insertLectureRating(ratings);
			
			lectureservice.updateLectureRatingRegister(ratings);
			
			
		}
	
		return "redirect:/stud/lookupScore";
	}
	
	@RequestMapping("scoreerror.do")
	public String startScore(){
		
		return "redirect:/stud/lookupScore";
	}
}
