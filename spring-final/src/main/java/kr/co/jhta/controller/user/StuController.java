package kr.co.jhta.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.service.user.StudentService;

@Controller
public class StuController {
	
	@Autowired
	StudentService stuService;
	
	@RequestMapping("/stuMain")
	public String stuMain() {
		return "/student/stuMain";
	}
	
	@RequestMapping("/stuInfo")
	public String stuInfo() {
		return "/student/stuInfo/stuInfo";
	}
	
	@RequestMapping("/stuEdit")
	public String stuEdit() {
		return "/student/stuInfo/stuEdit";
	}
	
}
