package kr.co.jhta.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StuLookupScoreController {

	@RequestMapping(value="lookupScore", method=RequestMethod.GET)
	public String lookupScore() {
		return "student/lookupScore/lookupScore";
	}
	
	@RequestMapping(value="lookupScore", method=RequestMethod.POST)
	public String lookupScorePost() {
		return "redirect:/student/lookupScore/lookupScore";
	}
}
