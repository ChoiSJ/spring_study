package kr.co.jhta.dao;

import java.util.List;

import kr.co.jhta.vo.Book;

public interface BookDao {
	
	List<Book> getAllBooks();
	void addBook(Book book);
	List<Book> searchBooks(Book book);
}
