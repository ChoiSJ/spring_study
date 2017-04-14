package kr.co.jhta.controller.interceptor;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.stu.Student;


public class LoginCheckInterceptor extends HandlerInterceptorAdapter{

	
	List<String> paths;
	public void setPaths(List<String> paths) {
		this.paths = paths;
	}
	
	private Boolean isMatch(String url){
		for(String path : paths){
			if(url.startsWith(path)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		String url = request.getRequestURI().replaceFirst(request.getContextPath(), "");		
		if(this.isMatch(url)) {
			HttpSession session = request.getSession(true);
			Object user = session.getAttribute("LOGIN_USER");
			if (user != null) {
				return true;
			} else {
				response.sendRedirect("login?err=deny");
				return false;
			}
		} else {
			return true;
		}
	}
}

