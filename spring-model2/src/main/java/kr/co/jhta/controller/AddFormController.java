package kr.co.jhta.controller;

import javax.servlet.http.HttpServletRequest;

import kr.co.jhta.model2.Controller;

public class AddFormController implements Controller {
	
	@Override
	public String exec(HttpServletRequest req) throws Exception {

		return "addform.jsp";
	}
}
