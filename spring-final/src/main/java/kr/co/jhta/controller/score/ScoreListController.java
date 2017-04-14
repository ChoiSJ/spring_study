package kr.co.jhta.controller.score;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.service.major.SemesterService;
import kr.co.jhta.service.score.ScoreService;
import kr.co.jhta.vo.Score;
import kr.co.jhta.vo.Scorelist;
import kr.co.jhta.vo.Semester;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.stu.Student;


@Controller
public class ScoreListController {
	
	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private SemesterService semesterSevice;
			
	@RequestMapping("/scorelist.do")
	public String scorelist(Model model){
		
		List<Score> scorelist = scoreService.getAllScoreList();
		List<Scorelist> scorelist2 = new ArrayList<Scorelist>();
		
		List<Semester> semesterlist = semesterSevice.getAllSemester();
		
		for(Score score : scorelist){
			Scorelist list = new Scorelist();
			Subject sub = scoreService.getSubjectInfoByNo(score.getRegister().getRegiNo());
			Student stu = scoreService.getStudentInfoByNo(score.getRegister().getStuNo());
			score.setRegister(scoreService.getRegiListByNo(score.getRegister().getRegiNo()));
			sub.setSelectNo(scoreService.getSemesterByNo(sub.getSelectNo().getNo()));
			
			list.setStudent(stu);
			list.setSubject(sub);
			list.setScore(score);
			list.setNo(score.getRegister().getRegiNo());
			
			scorelist2.add(list);
		}
		model.addAttribute("scorelist2", scorelist2);
		model.addAttribute("semesterlist", semesterlist);
		return "score/scorelist";
	}
	
	@RequestMapping(value="/scoreform.do", method=RequestMethod.GET)
	public String scoreedit(@RequestParam String sno, Model model){
		int no = Integer.parseInt(sno);
		Score score = scoreService.getScoreByNo(no);
		model.addAttribute("score", score);
		model.addAttribute("scoreupdate", new Score());
		return "score/scoreform";
	}
	
	@RequestMapping(value="/scoreform.do", method=RequestMethod.POST)
	public String scoreupdate(@Valid @ModelAttribute("scoreupdate") Score scores){
		System.out.println(scores);
		scoreService.updateScoreByNo(scores);
		return "redirect:/scorelist.do";
	}
}
