package kr.co.jhta.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.service.lecture.LectureService;
import kr.co.jhta.service.major.SubjectService;
import kr.co.jhta.service.sitemap.SitemapService;
import kr.co.jhta.service.user.EnrollService;
import kr.co.jhta.service.user.RegisubjectService;
import kr.co.jhta.service.user.StudentService;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.stu.Enroll;
import kr.co.jhta.vo.stu.EnrollSearchForm;
import kr.co.jhta.vo.stu.Regisubject;
import kr.co.jhta.vo.stu.Student;
import kr.co.jhta.webSocket.EnrollWebSocketHandler;

@Controller
@RequestMapping("/stud")
public class StuEnrollController {
	
	@Autowired
	StudentService stuService;
	
	@Autowired
	SubjectService subjectService;
	
	@Autowired
	EnrollService enrollService;
	
	@Autowired
	RegisubjectService regisubjectService;
	
	@Autowired
	SitemapService sitemapService;
	
	@Autowired
	LectureService lectureService;
	
	@Autowired
	EnrollWebSocketHandler noticeWebSocketHandler;
	
	private int nowScore = 0; 
			
	@RequestMapping(value="nowEnrollList", method=RequestMethod.GET)
	public String nowShowEnrollList(Model model, Student student) {
		
		model.addAttribute("student", student);
		List<SiteMap> deptList = sitemapService.getAllSitemapPreService();
		model.addAttribute("deptList", deptList);
		
		nowScore = stuService.getNowScoreService(student.getNo());
		model.addAttribute("applyScore", nowScore);
		
		List<Regisubject> regisubList = regisubjectService.getRegisByUserNoService(student.getNo());
		if(!regisubList.isEmpty()) {
			model.addAttribute("regisubList" , regisubList);
		}
		
		return "/student/enroll/nowEnrollList";
	}
	
	@RequestMapping(value="/enrollMain", method=RequestMethod.POST)
	public String enrollSearch(Model model, Student student, EnrollSearchForm searchForm) {
		
		model.addAttribute("student", student);
		List<SiteMap> deptList = sitemapService.getAllSitemapPreService();
		model.addAttribute("deptList", deptList);
		
		nowScore = stuService.getNowScoreService(student.getNo());
		model.addAttribute("applyScore", nowScore);
		
		if(searchForm.getOption1().equals("gradeAll")) {
			searchForm.setOption1(null);
		}
		
		List<Subject> subList = subjectService.searchEnrollByOptionService(searchForm);
		System.out.println(searchForm.getOption1());
		if(searchForm.getSelectMajor().equals("siteAll") && searchForm.getOption1() == null) {
			subList = subjectService.getallenroll();
		}
		model.addAttribute("subList", subList);
		
		List<Regisubject> regisubList = regisubjectService.getRegisByUserNoService(student.getNo());
		if(!regisubList.isEmpty()) {
			model.addAttribute("regisubList", regisubList);
		}
		
		return "/student/enroll/enrollMain";
	}
	
	@RequestMapping(value="/enrollMain", method=RequestMethod.GET)
	public String stuEnroll(Model model, Student student) {

		model.addAttribute("student", student);
		List<SiteMap> deptList = sitemapService.getAllSitemapPreService();
		model.addAttribute("deptList", deptList);
		
		nowScore = stuService.getNowScoreService(student.getNo());
		model.addAttribute("applyScore", nowScore);
		
		// 수강신청 목록 뿌려주기
		List<Subject> subList = subjectService.getEnrollListByTcodeService(student.getGrade(), student.getDivision());
		model.addAttribute("subList", subList);
		// 수강신청한 목록 아이디를 가져와 뿌려주기로 바꾸기 
		List<Regisubject> regisubList = regisubjectService.getRegisByUserNoService(student.getNo());
		if(!regisubList.isEmpty()) {
			model.addAttribute("regisubList" , regisubList);
		}

		return "/student/enroll/enrollMain";
	}
	
	@RequestMapping(value="/enrollSend", method=RequestMethod.GET)
	public String stuEnrollSending(@RequestParam(value="enrollNo") int enrollNo, Student student,
			@RequestParam(value="plusScore") int plusScore, Model model) throws Exception {
		
		nowScore = stuService.getNowScoreService(student.getNo());
		int maxScore = student.getMaxOneScore();
			
		Enroll enroll = enrollService.getEnrollByENoService(enrollNo);
		
		// 중복요일 중복시간 신청 불가
		boolean regiDayPass =true;
		String enrollTimes = enroll.getEnrollTime().replaceAll(",", "");
		List<Regisubject> regisubjectList =regisubjectService.getRegisByUserNoService(student.getNo());
		if(!regisubjectList.isEmpty()) {
			for(Regisubject regisubject : regisubjectList) {
				String newEnrollTimes = regisubject.getEnroll().getEnrollTime();
				if(enroll.getEnrollDay().equals(regisubject.getEnroll().getEnrollDay())) {					
					if(enrollTimes.matches(".*["+newEnrollTimes+"].*")) {
						regiDayPass = true;
						model.addAttribute("regiDayPass", regiDayPass);
						return "redirect:/stud/enrollMain";
					}
				}
			}			
		}
			
		
		// 최대인원 비교
		boolean check = checkEnrollMax(enroll.getEnrollNum(), enroll.getSubject().getLimitStu());		
		if(check) {
			// 추가할 수 있는지 조건 비교
			if(nowScore >= maxScore) {
				model.addAttribute("addFalse", "true");
				return "redirect:/stud/enrollMain";
			} else {
				enroll.setStudent(student);
				enrollService.updatePlusNowNumService(enrollNo);
				enrollService.addRegisubService(enroll);
				Enroll AfterEnroll = enrollService.getEnrollByENoService(enrollNo);
				Subject subject = subjectService.getsubByEnrollNoService(enrollNo);
				stuService.updateAddScoreService(plusScore, student.getNo());			
				model.addAttribute("applyScore", nowScore);
				noticeWebSocketHandler.sendMessage("up"+":"+student.getNo()+":"+enrollNo+":"+AfterEnroll.getEnrollNum()+":"+subject.getLimitStu()+":"+subject.getScore());
			}
		} else {			
			return "redirect:/stud/enrollMain?access=deny";
		}
		return "redirect:/stud/enrollMain";
	}	
	
	// 신청인원과 최대인원 비교
	private boolean checkEnrollMax(int nowNum, int maxNum) {
		if(nowNum >= maxNum) {
			return false;
		}
		return true;
	}
	
	
	@RequestMapping(value="/enrollCancle", method=RequestMethod.GET)
	public String stuEnrollCancel(@RequestParam("cancleNo") int cancleNo, Student student, @RequestParam("eno") int eno,
			@RequestParam(value="minusScore") int minusScore, Model model) throws Exception{
			
		regisubjectService.deleteRegisubByENoAndStuNoService(cancleNo,student.getNo());
		enrollService.updateMinusNowNumService(cancleNo);
		if(minusScore != 0) {			
			stuService.updateMinusScoreService(minusScore, student.getNo());
			nowScore = stuService.getNowScoreService(student.getNo());
			
			Subject subject = subjectService.getsubByEnrollNoService(eno);
			// enroll 정보 가져요기
			Enroll enroll = enrollService.getEnrollByENoService(eno);
			noticeWebSocketHandler.sendMessage("down"+":"+student.getNo()+":"+eno+":"+enroll.getEnrollNum() + ":" + subject.getLimitStu()+":"+subject.getScore());
			model.addAttribute("applyScore", nowScore);			
		}
		
		return "redirect:/stud/enrollMain";
	}
	
	// 대학을 선택하면 학과들이 검색되도록 하는 ajax 검색 기능
	@RequestMapping(value="/enrollSubjectSearch", method=RequestMethod.POST)
	public List<SiteMap> adminRegSubjectGetDept(String dept) {
		SiteMap siteMap = new SiteMap();
		siteMap.setPreCode(dept);
		
		return sitemapService.getAllSitemapSecService(siteMap);
	}
		
}
