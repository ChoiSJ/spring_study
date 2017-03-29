package kr.co.jhta.service;

import java.util.List;

import kr.co.jhta.vo.Book;

public interface BookService {
	
	void addbook(Book book);
	List<Book> listbook();
}
