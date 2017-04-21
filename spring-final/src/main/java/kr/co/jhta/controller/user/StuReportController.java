package kr.co.jhta.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.jhta.service.report.StuReportService;
import kr.co.jhta.vo.stu.Student;

@Controller
@RequestMapping("/stud")
public class StuReportController {

	@Autowired
	StuReportService stuReportService;
	
	@RequestMapping(value="/stuReport", method=RequestMethod.GET)
	public String stuReportForm(Student student) {
		
		
		
		return "student/report/stuReportForm";
	}
	
	
}
