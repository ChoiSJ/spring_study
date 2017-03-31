package kr.co.jhta.dao;

import java.util.List;
import java.util.Map;

import kr.co.jhta.vo.Book;

public interface BookDAO {
	
	void addbook(Book book);
	List<Book> listbook();
	Book detailbook(int no);
	void updatebook(Book book);
	List<Book> searchbook(Map<String, String> searchForm);
}
