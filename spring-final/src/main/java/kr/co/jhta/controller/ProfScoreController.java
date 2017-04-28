package kr.co.jhta.controller;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.jhta.service.score.ScoreService;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.Score;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.stu.Regisubject;

@Controller
public class ProfScoreController {
	@Autowired
	private ScoreService scoreService;
	
	@RequestMapping("/prof/profscorelist")
	public String profscorelist(HttpSession session, Model model){
		Professor prof = (Professor) session.getAttribute("LOGIN_USER");
		List<Regisubject> regilist =  scoreService.getAllScorelistByProfID(prof.getId());
		List<Subject> sublist = scoreService.getsubjectlistByProfId(prof.getNo());
		
		model.addAttribute("regilist", regilist);
		model.addAttribute("sublist", sublist);
		
		return "/prof/score/profscorelist";
	}
	
	@RequestMapping(value="/prof/scoreform", method=RequestMethod.GET)
	public String scoreedit(@RequestParam int sno, @RequestParam int psco ,Model model){
		Score score = scoreService.getScoreByNo(sno);
		
		model.addAttribute("no", sno);
		model.addAttribute("psco", psco);
		model.addAttribute("score", score);
		model.addAttribute("scoreupdate", new Score());
		return "/prof/score/scoreform";
	}
	
	@RequestMapping(value="/prof/scoreform", method=RequestMethod.POST)
	public String scoreupdate(@Valid @ModelAttribute("scoreupdate") Score scores, Errors errors){
		if(errors.hasErrors()){
			return "/prof/scoreform";
		}
		scoreService.updateScoreByNo(scores);
		return "redirect:/prof/profscorelist";
	}
	
	@RequestMapping(value="/prof/subSearch.do", method=RequestMethod.POST)
	public @ResponseBody List<Regisubject> searchScoreList(@RequestParam(value="sub") String sub, HttpSession session){
		Professor prof = (Professor) session.getAttribute("LOGIN_USER");
		HashMap<String, Object> searchlist = new HashMap<String, Object>();
		searchlist.put("subname", sub);
		searchlist.put("pid", prof.getId());
		return scoreService.getSearchScorelistByhash(searchlist);
	}
}
