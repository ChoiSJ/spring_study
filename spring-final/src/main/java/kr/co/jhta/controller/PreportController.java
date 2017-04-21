package kr.co.jhta.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.vo.PreportForm;

@Controller
@RequestMapping("/report")
public class PreportController {
	@RequestMapping("/reportform")
	public String reportform(@Valid @ModelAttribute("reportform")PreportForm reportform){
		return "/report/reportform";
	}
}
