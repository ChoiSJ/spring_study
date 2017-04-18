package kr.co.jhta.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.jhta.service.professor.ProfessorService;
import kr.co.jhta.service.user.StudentService;
import kr.co.jhta.vo.LoginForm;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.Sessioncheck;
import kr.co.jhta.vo.stu.Student;


@Controller
public class LoginController {
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginform(){
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginprocess(LoginForm loginForm,HttpSession session){
		Sessioncheck sessioncheck = new Sessioncheck();				
		if(loginForm.getLoginType().equals("stud")){
			Student stud = studentService.loginByStudent(loginForm);
			if(stud == null){
				return "redirect:/login?err=fail";
			}
			sessioncheck.setCheck("stud");
			session.setAttribute("SESSION_CHECK", sessioncheck);
			session.setAttribute("LOGIN_USER", stud);
			return "redirect:/stud/home";
		}else{
			Professor prof = professorService.loginByProfessor(loginForm);
			if(prof == null){
				return "redirect:/login?err=fail";
			}
			if(prof.getId().equals("admin")){
				sessioncheck.setCheck("admin");
				session.setAttribute("SESSION_CHECK", sessioncheck);
				session.setAttribute("LOGIN_USER", prof);
				return "redirect:/admin/home";	
			}
			sessioncheck.setCheck("prof");
			session.setAttribute("SESSION_CHECK", sessioncheck);
			session.setAttribute("LOGIN_USER", prof);
			return "redirect:/prof/home";
		}
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/login?message=logout";
	}
	
	

}
