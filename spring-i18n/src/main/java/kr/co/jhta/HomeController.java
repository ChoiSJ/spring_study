package kr.co.jhta;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping("/home.do")
	public String home(Locale locale, 
			@RequestParam(value="name", required=false, defaultValue="홍진호") String name, 
			Model model) {
		//System.out.println("언어 설정:" + locale.getLanguage());
		String greetingMessage = messageSource.getMessage("welcome.greeting", new Object[]{name}, locale);
		System.out.println("인사말:" + greetingMessage);
		model.addAttribute("message", greetingMessage);
		
		return "index";
	}
	
	@RequestMapping("/about.do")
	public String about(Model model) {
		model.addAttribute("username", "임요환");
		model.addAttribute("userid", "im");
		
		return "about";
	}
}
