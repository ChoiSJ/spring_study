package kr.co.jhta.controller.open;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.service.openlecture.OpenLectureService;
import kr.co.jhta.vo.InvestGationAttribute;
import kr.co.jhta.vo.InvestgationItems;
import kr.co.jhta.vo.LectureEvaluationSheet;
import kr.co.jhta.vo.LectureRatingSave;
import kr.co.jhta.vo.ProfessorOpenLecture;
import kr.co.jhta.vo.ProfessorSubject;
import kr.co.jhta.vo.stu.Student;

@RequestMapping("/admin")
@Controller
public class OpenLecture {

	@Autowired
	private OpenLectureService lectureservice;
		
	@RequestMapping("openLectureMain.do")
	public String openLectureMain(){
		
		return "/openlecture/openlectureratingmain";
	}
	
	
	
	//openinquiries.do 테이블 전체 조회
	@RequestMapping("openLectureTableAll.do")
	public String openlectureTableAlls(Model model){
		
		List<ProfessorSubject> professorListTable = lectureservice.subjectRatingInquiriesAll();
		model.addAttribute("professorListTable", professorListTable);
		
		return "/openlecture/openinquiries";
	}
	
	

	
	//강의 테이블 뿌려주는 코딩
	@RequestMapping("openratingregister.do")
	public String openLectureRegister(Model model){
	
		List<ProfessorOpenLecture> openlecturelist = lectureservice.getInformationOfProfessorList();
		System.out.println("값:"+openlecturelist);
		
		model.addAttribute("openlecturelist",openlecturelist);
		
		
		
		return "openlecture/openlectureratingregister";
	}	
	
	//강의 평가 추가하기 등록
	@RequestMapping("investigating.do")
	public String addInvestingItems(InvestgationItems items, Errors errors)throws Exception{
		
		if(errors.hasErrors()){
			
			System.out.println(errors.getAllErrors());
			return "redirect:/admin/openratingregister.do";
			
		}else{
			
			List<String> itemsList =  items.getContents();
			String register = items.getRegister();
			int no =items.getSubjectNo();
			String professorId = items.getProfessorId();
			InvestGationAttribute item = new InvestGationAttribute();
			
			for(int i=0; i<itemsList.size(); i++){
				
				item.setRegister(register);
				item.setSubjectNo(no);
				item.setContents(itemsList.get(i));
				item.setProfessorId(professorId);
				
				lectureservice.addInvestgation(item);
			}
			
			lectureservice.updateLectureRatingRegisterEnrollTable(items.getSubjectNo());
			
			return"redirect:/admin/openLectureTableAll.do";
		}
		
		
	}
	
}
