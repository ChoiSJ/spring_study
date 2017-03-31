package kr.co.jhta.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.jhta.service.BookService;
import kr.co.jhta.vo.Book;

@Controller
public class IndexController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/index.hta", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/index.hta", method=RequestMethod.POST)
	public String searchbook(String category, String bookword, Model model) {
		Map<String, String> searchForm = new HashMap<String, String>();
		searchForm.put("category", category);
		searchForm.put("bookword", bookword);
		List<Book> bookLists = bookService.searchbook(searchForm);
		model.addAttribute("bookLists", bookLists);
		return "index";
	}
}
