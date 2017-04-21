package kr.co.jhta.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.jhta.vo.MessageForm;

@Controller
public class MessageController {
	
	@RequestMapping("/adminsendmessagebox")
	public String adminSendEmailBox() {
		return "administer/adminsendmessagebox";
	}
	
	@RequestMapping("/adminrecmessagebox")
	public String adminRecieveEmailBox() {
		return "administer/adminrecmessagebox";
	}
	
	@RequestMapping("/adminmessageform")
	public String adminMessageForm(Model model) {
		model.addAttribute("messageForm", new MessageForm());
		return "administer/adminmessageform";
	}
	
	@RequestMapping(value="/sendmessage", method=RequestMethod.POST)
	public String sendMessage(HttpSession session) {
		
		System.out.println(session.getAttribute("LOGIN_USER"));
		return null;
	}
}
