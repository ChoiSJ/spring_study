package kr.co.jhta.controller.timechart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.jhta.service.timechart.TimeChartService;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.TimeChart;
import kr.co.jhta.vo.stu.Student;

@RestController
public class TimeChartAjaxController {
	
	@Autowired
	private TimeChartService timeChartService;
	
	@GetMapping(path="/stud/studenttimechart")
	public @ResponseBody List<TimeChart> getAllTimeChartByStuNo(Student student){
		return timeChartService.getEnroll(student.getNo());
		
	}
	
	@GetMapping(path="/prof/timeschedule")
	public @ResponseBody List<TimeChart> getAllTomeChartByProfNo(Professor professor){
		return timeChartService.getProfEnroll(professor.getId());
	}
}
