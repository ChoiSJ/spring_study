package kr.co.jhta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.jhta.service.BookService;
import kr.co.jhta.vo.Book;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="addbook.hta", method=RequestMethod.GET)
	public String addBookGet(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@RequestMapping(value="addbook.hta", method=RequestMethod.POST)
	public String addBookPost(@ModelAttribute("book") Book book) {
		bookService.addbook(book);
		return "redirect:list.hta";
	}
	
	@RequestMapping("listbook.hta")
	public String listbook(Model model) {
		model.addAttribute("bookLists", bookService.listbook());
		return "listbook";
	}
}
