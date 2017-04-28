package kr.co.jhta.controller.timechart;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.jhta.vo.stu.Student;

@Controller
public class TimeChartController {
	
	// 학생 시간표
	@RequestMapping(value="/stud/studenttime", method=RequestMethod.GET)
	public String getAllTimeSubject() {
		
		return "/timechart/studenttimechart";
	}
	
	// 교수 시간표
	@RequestMapping(value="/prof/proftime", method=RequestMethod.GET)
	public String getAllTimeProfSubject(){
		return "/timechart/proftimechart";
	}
}