package kr.co.jhta.todo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.jhta.todo.service.UserService;
import kr.co.jhta.todo.vo.User;
import kr.co.jhta.todo.vo.UserForm;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ExceptionHandler(RuntimeException.class)
	public String runtimeExceptionHandler(RuntimeException ex) {
		return "error/server-error";
	}
	
	@RequestMapping(value="/register.do", method=RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("userform", new UserForm());
		
		return "registerform";
	}
	
	/*
	 * register(@ModelAttribute("이름") @Valid Userform userform)
	 * 1. 폼 입력값을 담기 위해서 UserForm 객체를 스프링이 생성
	 * 2. 생성된 UserForm 객체의 변수명과 일치하는 폼 입력값을 저장
	 * 3. @Valid 가 UserForm 객체에 저장된 값에 대한 유효성 체크를 수행한다.
	 * - 유효성 체크를 통과하지 못한 항목이 있으면, Errors 객체에 에러가 저장된다.
	 * 4. @ModelAttribute 는 1번에서 생성한 객체를 Model 에 지정된 이름으로 담는다.
	 * - 유효성 체크를 통과하지 못한 경우 입력폼에 기존 입력값을 담고 있는 UserForm 객체를 registerform.jsp 에 전달하기 위해서이다.
	 * @ModelAttribute("userform") Userform userform
	 * ---> model.attribute("userform", userform);
	 */
	@RequestMapping(value="/register.do", method=RequestMethod.POST)
	public String register(@Valid @ModelAttribute("userform") UserForm userform, Errors errors) {
		if (errors.hasErrors()) {
			return "registerform";
		}
		
		User user = new User();
		BeanUtils.copyProperties(userform, user);
		userService.registerUser(user);
		
		return "redirect:/home.do";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginform(Model model) {
		model.addAttribute("userform", new UserForm());
		
		return "loginform";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(String id, String pwd, HttpSession session) {
		if (StringUtils.isEmpty(id) || StringUtils.isEmpty(pwd)) {
			return "redirect:/login.do?error=invalid";
		}
		
		User user = userService.getLoginUserInfo(id, pwd);
		session.setAttribute("LOGIN_USER", user);
		
		return "redirect:/home.do";
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/home.do";
	}
}
