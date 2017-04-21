package kr.co.jhta.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.jhta.service.lecture.LectureService;
import kr.co.jhta.service.major.SubjectService;
import kr.co.jhta.service.sitemap.SitemapService;
import kr.co.jhta.service.user.EnrollService;
import kr.co.jhta.service.user.RegisubjectService;
import kr.co.jhta.service.user.StudentService;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.stu.Enroll;
import kr.co.jhta.vo.stu.Regisubject;
import kr.co.jhta.vo.stu.Student;

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
		
	@RequestMapping(value="/enrollMain", method=RequestMethod.GET)
	public String stuEnroll(Model model, Student student) {
		
		
		
		List<SiteMap> deptList = sitemapService.getAllSitemapPreService();
		if(deptList == null) {
			throw new RuntimeException("StuController deptList is not found");
		}
		
		model.addAttribute("deptList", deptList);
		// 수강신청 목록 뿌려주기
		
		List<Enroll> enrollList = enrollService.getAllEnrollByTcodeService(student.getDivision());
		if(!enrollList.isEmpty()) {			
			model.addAttribute("enrollList", enrollList);
		}
		List<Subject> subList = subjectService.getallenroll();
		model.addAttribute("subList", subList);
		// 수강신청한 목록 아이디를 가져와 뿌려주기로 바꾸기 
		List<Regisubject> regisubList = regisubjectService.getRegisByUserNoService(student.getNo());
		if(!regisubList.isEmpty()) {			
			model.addAttribute("regisubList" , regisubList);
		}
		
		return "/student/enroll/enrollMain";
	}
	
	@RequestMapping(value="/enrollSend", method=RequestMethod.GET)
	public String stuEnrollSending(@RequestParam(value="enrollNo") int enrollNo, Student student) {
		// 사용자가 같은지 비교조건 추가
		System.out.println(enrollNo);
		Enroll enroll = enrollService.getEnrollByENoService(enrollNo);
		boolean check = checkEnrollMax(enroll.getEnrollNum(), enroll.getSubject().getLimitStu());
		if(check) {
			enroll.setStuNo(student.getNo());
			enrollService.updatePlusNowNumService(enrollNo);
			enrollService.addRegisubService(enroll);
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
	public String stuEnrollCancel(@RequestParam int cancleNo) {
		regisubjectService.deleteRegisubByENoService(cancleNo);
		enrollService.updateMinusNowNumService(cancleNo);
		return "redirect:/stud/enrollMain";
	}
	
	// 대학을 선택하면 학과들이 검색되도록 하는 ajax 검색 기능
	@RequestMapping(value="/enrollSubjectSearch", method=RequestMethod.POST)
	public @ResponseBody List<SiteMap> adminRegSubjectGetDept(String dept) {
		SiteMap siteMap = new SiteMap();
		siteMap.setPreCode(dept);
		
		return sitemapService.getAllSitemapSecService(siteMap);
	}
		

		
}
