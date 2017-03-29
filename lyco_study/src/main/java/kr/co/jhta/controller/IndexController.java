package kr.co.jhta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("index.hta")
	public String index() {
		return "index";
	}
}
