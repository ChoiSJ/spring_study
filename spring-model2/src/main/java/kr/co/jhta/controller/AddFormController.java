package kr.co.jhta.controller;

import javax.servlet.http.HttpServletRequest;

import kr.co.jhta.model2.Controller;
import kr.co.jhta.service.BookService;

public class AddFormController implements Controller {
	
	private BookService bookService;
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@Override
	public String exec(HttpServletRequest req) throws Exception {

		return null;
	}
}
