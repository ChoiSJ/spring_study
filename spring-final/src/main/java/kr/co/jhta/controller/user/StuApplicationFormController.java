package kr.co.jhta.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.jhta.service.appli.LeaveService;
import kr.co.jhta.service.user.ApplicationService;
import kr.co.jhta.service.user.StudentService;
import kr.co.jhta.vo.appli.Leave;
import kr.co.jhta.vo.stu.Student;

@Controller
@RequestMapping("/stud")
public class StuApplicationFormController {
	
	@Autowired
	ApplicationService appliService;
	
	@Autowired
	StudentService stuService;
	
	@Autowired
	LeaveService leaveService;
	
	static String ccName = "";
	
	@RequestMapping(value="/leave", method=RequestMethod.GET)
	public String stuLeave(Model model, Student student) {
		if(student.getName() == null) {
			return "redirect:/login?err=deny";
		}
		
		// 기본 정보 담기
		model.addAttribute("student", student);		
		// 휴학 정보 담기
		List<Leave> leaveList = leaveService.getAllEnrolledLeaveByStuNoService(student.getNo());
		for(Leave leave : leaveList ) {
			ccName = leaveService.getCnameByCcodeService(leave.getCode());
			leave.setcName(ccName);
		}
		model.addAttribute("leaveList", leaveList);
				
		return "/student/applications/leaveForm";
	}
		
	@RequestMapping(value="/reinstate", method=RequestMethod.GET)
	public String setReinstate(Model model, Student student){
		
		// 기본 정보 담기
		model.addAttribute("student", student);		
		return "/student/applications/ReinstatementForm";
	}
	
	
	// 학적상태를 학생 번호와 C코드를 받아 반환한다.
	public String getTnameInController(Student student) {
		String tName = stuService.getTnameByTcodeService(student.getNo(), student.getDivision());
		return tName;
	}
}
