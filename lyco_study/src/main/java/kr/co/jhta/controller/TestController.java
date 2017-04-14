package kr.co.jhta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/testreceive.hta")
	public String receive() {
		return "final/testreceive";
	}
	
	@RequestMapping("/testwrite.hta")
	public String write() {
		return "final/testwrite";
	}
}
