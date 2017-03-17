package kr.co.jhta.service;

import java.util.List;

import kr.co.jhta.vo.Book;

public interface BookService {
	
	List<Book> findAllBooks();
	void addNewBook(Book book);
	List<Book> searchBooks(Book book);
}
