package kr.co.jhta.service;

import java.util.List;

import kr.co.jhta.dao.BookDao;
import kr.co.jhta.vo.Book;

public class BookServiceImpl implements BookService {
	
	private BookDao bookDao;
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@Override
	public List<Book> findAllBooks() {
		List<Book> bookList = bookDao.getAllBooks();
		return bookList;
	}
	
	@Override
	public void addNewBook(Book book) {
		List<Book> bookList = bookDao.getAllBooks();
		boolean isExist = false;
		
		for (Book b : bookList) {
			if (b.getTitle().equals(book.getTitle())) {
				isExist = true;
				break;
			}
		}
		
		if (!isExist) {
			bookDao.addBook(book);
		}
	}
	
	@Override
	public List<Book> searchBooks(Book book) {
		return bookDao.searchBooks(book);
	}
}
