package kr.co.jhta.controller.view;

import java.util.*;

import javax.mail.internet.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.mail.*;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import kr.co.jhta.service.user.*;
import kr.co.jhta.vo.stu.*;

@Controller
public class StuEmailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private StudentService stuService;
	
	@RequestMapping(value="/sendId", method=RequestMethod.POST)
	public String sendEmainIdAction(@RequestParam("email") String email) throws Exception {
		
		MimeMessage message = mailSender.createMimeMessage();

		String id = stuService.getStuIdByEmailService(email);
		
		if (id != null) {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setSubject("jhta대학교 아이디 안내입니다.");
			helper.setText("회원님의 아이디는 '" + id + "' 입니다.");
			helper.setTo(email);
			
			try {
				mailSender.send(message);
			} catch (MailException e) {
				e.printStackTrace();
			}
			return "redirect:/login";
		} else {
			return "redirect:/login";
		}
		
	}
	
	
	@RequestMapping(value="/sendPwd", method=RequestMethod.POST)
	public String sendEmailAction(@RequestParam("id") int id, String email) throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
		String pwd = stuService.getStuPwdByEmailAndIdService(String.valueOf(id), email);

		if(pwd!=null) {

			// 랜덤 문자열 10개 생성
			Random randomValue =new Random();
			StringBuffer randomintValue =new StringBuffer();
			 
			for(int i=0;i<10;i++){
			    if(randomValue.nextBoolean()){
			    	randomintValue.append((char)((int)(randomValue.nextInt(26))+97));
			    }else{
			    	randomintValue.append((randomValue.nextInt(10))); 
			    }
			}
			
			Student student = new Student();
			student.setId(String.valueOf(id));
			student.setPwd(randomintValue.toString());
			stuService.updateStudentPwdService(student);
			
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setSubject("jhta대학교 비밀번호 안내입니다.");
			helper.setText("임시 비밀번호는 '" + randomintValue.toString() + "' 입니다.");
			helper.setTo(email);
			
			try {
				mailSender.send(message);
			} catch (MailException e) {
				e.printStackTrace();
			}
			return "redirect:/login";
		} else {
			return "redirect:/logout";			
		}		
	}
	
}
