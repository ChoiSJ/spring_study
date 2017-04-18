package kr.co.jhta.controller.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
public class LoginCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI().replaceFirst(request.getContextPath(), "");
		System.out.println("login = "+url);
		
		Object user = request.getSession(true).getAttribute("LOGIN_USER");
		if(user != null){
			System.out.println("인증된 사용자입니다.");
			return true;
		}
		System.out.println("미 인증 사용자입니다.");
		response.sendRedirect("/jhta/login?err=deny");			
		return false;
		
	}
}

