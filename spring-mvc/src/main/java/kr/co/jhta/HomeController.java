package kr.co.jhta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@Autowired
	private JsonView jsonView;
	
	@Autowired
	private ExcelView excelView;
	
	@RequestMapping("/home.do")
	public String a(Model model) {
		model.addAttribute("msg", "반갑습니다...");
		
		return "home";
	}
	
	@RequestMapping("/about.do")
	public ModelAndView b() {
		ModelAndView mav = new ModelAndView();
		
		// ModelAndView 객체에 데이터 담기
		mav.addObject("question1", "회원가입 과정이 궁금해요.");
		mav.addObject("question2", "탈퇴는 어떻게 하나요?");
		
		// 이동할 뷰페이지 설정하기
		mav.setViewName("about");
		
		return mav;
	}
	
	@RequestMapping("/help.do")
	public String c() {
		return "help";
	}
	
	@RequestMapping("/data.do")
	public ModelAndView d() {
		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addObject("data", new int[] {100, 50, 40});
		
		return mav;
	}
	
	@RequestMapping("/xls.do")
	public ModelAndView e() {
		ModelAndView mav = new ModelAndView();
		mav.setView(excelView);
		mav.addObject("data", new String[] {"Jane", "Adam", "Tayler"});
		
		return mav;
	}
}
