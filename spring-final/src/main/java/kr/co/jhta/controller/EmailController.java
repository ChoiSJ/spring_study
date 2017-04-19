package kr.co.jhta.controller;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.jhta.vo.Email;

@Controller
public class EmailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping("/adminsendemail")
	public String adminSendEmail(Model model) {
		model.addAttribute("email", new Email());
		return "administer/adminsendemail";
	}
	
	@RequestMapping(value="/adminsendprocess", method=RequestMethod.POST)
	public String adminsendprocess(@ModelAttribute(name="email") Email email) {
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			
			helper.setSubject(email.getTitle());
			helper.setText(email.getContents());
			helper.setTo(email.getAddress());
			
			if (email.getFile() != null) {
				helper.addAttachment(email.getFile().getOriginalFilename(), email.getFile());
			}
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		try {
			mailSender.send(message);
		} catch (MailException e) {
			e.printStackTrace();
		}
		
		return "redirect:/adminsendemail";
	}
}
