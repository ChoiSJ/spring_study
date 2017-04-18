package kr.co.jhta.controller.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.jhta.vo.Sessioncheck;
public class RoleCheckInterceptor extends HandlerInterceptorAdapter{
		
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI().replaceFirst(request.getContextPath(), "");
		System.out.println("role = "+url);
		Sessioncheck sc = (Sessioncheck) request.getSession(true).getAttribute("SESSION_CHECK");
		
		if(sc.getCheck().equals(url.split("/")[1])){
			System.out.println("접속이 인가된 사용자입니다.");
			return true;
		}
		
		System.out.println("접속 권한이 없습니다.");
		response.sendRedirect("/jhta/"+sc.getCheck()+"/home");
		return false;
	}
}
