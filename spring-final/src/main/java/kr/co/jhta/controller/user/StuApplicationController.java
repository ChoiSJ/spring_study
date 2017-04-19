package kr.co.jhta.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.jhta.service.user.ApplicationService;
import kr.co.jhta.service.user.StudentService;
import kr.co.jhta.vo.stu.Student;

@Controller
@RequestMapping("/stud")
public class StuApplicationController {
	
	@Autowired
	ApplicationService appliService;
	
	@Autowired
	StudentService stuService;
	
	
	@RequestMapping(value="/leave", method=RequestMethod.GET)
	public String stuLeave(Model model, Student student) {
		if(student.getName() == null) {
			return "redirect:/login?err=deny";
		}
		
		// 기본 정보 담기
		model.addAttribute("student", student);
		String tName = stuService.getTnameByTcodeService(student.getDivision());
		model.addAttribute("tName", tName);

		return "/student/applications/leaveForm";
	}
	
	@RequestMapping(value="/leave", method=RequestMethod.POST)
	public String stuLeaveProcess(Model model, Student student) {
		
		return null;
	}
	
	@RequestMapping(value="/reinstate", method=RequestMethod.GET)
	public String setReinstate(Model model, Student student){
		
		// 기본 정보 담기
		model.addAttribute("student", student);
		String tName = stuService.getTnameByTcodeService(student.getDivision());
		model.addAttribute("tName", tName);
		
		return "/student/applications/ReinstatementForm";
	}
	
	@RequestMapping(value="/reinstate", method=RequestMethod.POST)
	public String setReinstateProcess(Model model, Student student){
		
		return "/student/applications/ReinstatementForm";
	}
	
	
	
}
