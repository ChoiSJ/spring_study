package kr.co.jhta.controller.user;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import kr.co.jhta.service.score.AttendanceService;
import kr.co.jhta.service.score.ScoreService;
import kr.co.jhta.vo.Scorelist;
import kr.co.jhta.vo.stu.Student;

@Controller
public class StuAttendanceController {
	
	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private AttendanceService attService;
	
	@RequestMapping(value="stud/stuAttendance", method=RequestMethod.GET)
	public String stuAttendance(HttpSession session, Model model){
		Student stu = (Student) session.getAttribute("LOGIN_USER");
		List<String> semelist = scoreService.getSemeNameByStuNo(stu.getNo());
		List<Scorelist> scorelist = attService.getAttInfolistByStuNo(stu.getNo());
		
		System.out.println(scorelist);
		
		model.addAttribute("scorelist", scorelist);
		model.addAttribute("semelist", semelist);
		return "/student/attendance/stuAttendance";
	}
}
