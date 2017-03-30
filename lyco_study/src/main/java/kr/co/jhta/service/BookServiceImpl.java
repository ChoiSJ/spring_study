package kr.co.jhta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.BookDAO;
import kr.co.jhta.vo.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDao;
	
	@Override
	public void addbook(Book book) {
		bookDao.addbook(book);
	}

	@Override
	public List<Book> listbook() {
		return bookDao.listbook();
	}
	
	@Override
	public Book detailbook(int no) {
		return bookDao.detailbook(no);
	}
	
	@Override
	public void updatebook(Book book) {
		bookDao.updatebook(book);
	}
}
