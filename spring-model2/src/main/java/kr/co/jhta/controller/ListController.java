package kr.co.jhta.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.jhta.model2.Controller;
import kr.co.jhta.service.BookService;
import kr.co.jhta.vo.Book;

public class ListController implements Controller {
	
	private BookService bookService;
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@Override
	public String exec(HttpServletRequest req) throws Exception {
		List<Book> bookList = bookService.findAllBooks();
		req.setAttribute("bookList", bookList);
		
		return "list.jsp";
	}
}
