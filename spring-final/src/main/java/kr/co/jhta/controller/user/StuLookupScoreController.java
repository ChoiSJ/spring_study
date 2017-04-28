package kr.co.jhta.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.jhta.service.score.ScoreService;
import kr.co.jhta.vo.SemesterAvg;
import kr.co.jhta.vo.stu.Regisubject;
import kr.co.jhta.vo.stu.Student;

@Controller
public class StuLookupScoreController {
	
	@Autowired
	private ScoreService scoreService;
	
	@RequestMapping(value="stud/lookupScore", method=RequestMethod.GET)
	public String lookupScore(HttpSession session, Model model) {
		Student stu = (Student) session.getAttribute("LOGIN_USER");
		List<Regisubject> regilist = scoreService.getSearchInfoBySno(stu.getNo());
		List<String> semelist = scoreService.getSemeNameByStuNo(stu.getNo());
		
		model.addAttribute("semelist", semelist);
		model.addAttribute("regilist", regilist);
		
		return "/student/lookupScore/lookupScore";
	}
	
	@RequestMapping(value="stud/lookupAllScore", method=RequestMethod.GET)
	public String lookupScorePost(HttpSession session, Model model) {
		Student stu = (Student) session.getAttribute("LOGIN_USER");
		List<SemesterAvg> savg = scoreService.getSemesterAvgBySno(stu.getNo());
		List<Regisubject> regilist = scoreService.getSearchInfoBySno(stu.getNo());
		SemesterAvg savgtotal = scoreService.getSemesterAvgTotalBySno(stu.getNo());
		
		model.addAttribute("savg", savg);
		model.addAttribute("savgtotal", savgtotal);
		model.addAttribute("regilist", regilist);
		
		return "/student/lookupScore/lookupAllScore";
	}
}
