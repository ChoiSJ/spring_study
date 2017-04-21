package kr.co.jhta.controller.open;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SupplementaryLecture {

	@RequestMapping("/supplementarylecture.do")
	public String setOpenlectureRegister(){
		
		return "supplementarylecture/supplementarylecture"; 
	}
}
