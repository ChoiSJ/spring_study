package kr.co.jhta;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SampleController {
	
	@RequestMapping("/sample.do")
	public String sample(Model model) {
		model.addAttribute("scoreForm", new ScoreForm());
		return "sample";	// <--- /WEB-INF/views/sample.jsp 로 이동...
	}
	
	@RequestMapping("/list.do")
	public String list(@RequestParam(value="pno", required=false, defaultValue="1") int pno,
			@RequestParam(value="sort", required=false, defaultValue="date") String sort) {
		System.out.println("페이지번호:" + pno);
		System.out.println("정렬기준:" + sort);
		
		return "success";
	}
	
	@RequestMapping("/add.do")
	public String add(@Valid ScoreForm scoreForm, BindingResult errors) {
		if (errors.hasErrors()) {
			System.out.println("유효하지 않은 값이 들어 있습니다.");
			return "sample";
		}
	
		System.out.println(scoreForm);
		return "success";
	}
}
