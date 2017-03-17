package kr.co.jhta.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import kr.co.jhta.model2.Controller;
import kr.co.jhta.service.BookService;
import kr.co.jhta.vo.Book;

public class SearchController implements Controller {
	
	private static Logger logger = Logger.getLogger(SearchController.class);
	private BookService bookService;
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@Override
	public String exec(HttpServletRequest req) throws Exception {
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		
		logger.info("title=["+title+"]");
		logger.info("author=["+author+"]");
		logger.info("publisher=["+publisher+"]");
		
		Book book = new Book();
		
		if (!title.isEmpty()) {
			book.setTitle(title);
		}
		if (!author.isEmpty()) {
			book.setAuthor(author);
		}
		if (!publisher.isEmpty()) {
			book.setPublisher(publisher);
		}
		
		List<Book> bookList = bookService.searchBooks(book);
		req.setAttribute("bookList", bookList);
		
		return "list.jsp";
	}
}
