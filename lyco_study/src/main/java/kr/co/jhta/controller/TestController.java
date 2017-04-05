package kr.co.jhta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/test.hta")
	public String index() {
		return "final/test";
	}
}
