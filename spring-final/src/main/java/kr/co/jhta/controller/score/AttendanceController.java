package kr.co.jhta.controller.score;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.service.score.AttendanceService;
import kr.co.jhta.service.score.ScoreService;
import kr.co.jhta.vo.Attendance;
import kr.co.jhta.vo.Scorelist;
import kr.co.jhta.vo.stu.Student;

@Controller
public class AttendanceController {
	@Autowired
	AttendanceService attService;
	
	@Autowired
	ScoreService scoreService;
	
	@RequestMapping("/admin/attinfolist.do")
	public String attinfolist(@RequestParam String stuno, Model model){
		int stno = Integer.parseInt(stuno);
		List<Scorelist> scorelist = attService.getAttInfolistByStuNo(stno);
		Student stuinfo = scoreService.getStudentInfoByNo(stno);
		model.addAttribute("scorelist", scorelist);
		model.addAttribute("stuinfo", stuinfo);
		return "score/attendence";
	}
	
	@RequestMapping("/admin/attform.do")
	public String attform(@RequestParam String attno, @RequestParam String stuno, @RequestParam String scono ,Model model){
		int atno = Integer.parseInt(attno);
		int stno = Integer.parseInt(stuno);
		int sno = Integer.parseInt(scono);
		
		model.addAttribute("sno", sno);
		model.addAttribute("atno", atno);
		model.addAttribute("stno", stno);
		
		return "score/attendenceform";
	}
	
	@RequestMapping(value="/admin/attsavetest.do", method=RequestMethod.POST)
	public String attSave(@RequestBody Attendance week){
		attService.updateAttendanceByAttno(week);
		attService.updateAttScoreByScoreNo(week);
		return "score/attendence";
	}
}
