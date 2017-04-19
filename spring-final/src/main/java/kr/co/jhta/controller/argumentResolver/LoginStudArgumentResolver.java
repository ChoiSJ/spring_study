package kr.co.jhta.controller.argumentResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import kr.co.jhta.vo.stu.Student;

public class LoginStudArgumentResolver implements HandlerMethodArgumentResolver {


	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return Student.class.isAssignableFrom(parameter.getParameterType());
	}
	
	
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, 
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		HttpSession session = request.getSession(true);
		
		Student student = (Student) session.getAttribute("LOGIN_USER");
		
		if(student == null) {
			return null;
		}
		return student;		
	}

}
