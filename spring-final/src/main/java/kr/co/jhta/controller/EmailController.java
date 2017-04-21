package kr.co.jhta.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.jhta.service.message.MessageService;
import kr.co.jhta.vo.Email;

@Controller
public class EmailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping("/adminsendemail")
	public String adminSendEmail(Model model) {
		model.addAttribute("email", new Email());
		return "administer/adminsendemail";
	}
	
	@RequestMapping(value="/adminsendprocess", method=RequestMethod.POST)
	public String adminSendProcess(@ModelAttribute(name="email") Email email) {
		MimeMessage message = mailSender.createMimeMessage();
		
		// List 파일을 Array 로 바꿔주는 코드
		String[] addressList = email.getAddress().toArray(new String[email.getAddress().size()]);
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			
			helper.setSubject(email.getTitle());
			helper.setText(email.getContents());
			helper.setTo(addressList);
			
			if (!email.getFile().getOriginalFilename().equals("")) {
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
	
	@RequestMapping("/adminAddressSearch")
	public @ResponseBody List<?> adminAddressSearch(String checkedRadio, String searchWord) {
		List<?> resultList = new ArrayList<Object>();
		
		if (checkedRadio.equals("stu")) {
			resultList = messageService.getAddressByStuName(searchWord);
			System.out.println(resultList);
		} else if (checkedRadio.equals("pro")) {
			resultList = messageService.getAddressByProName(searchWord);
		}
		
		return resultList;
	}
}
