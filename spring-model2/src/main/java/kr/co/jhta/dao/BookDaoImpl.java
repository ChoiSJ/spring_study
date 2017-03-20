package kr.co.jhta.dao;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import kr.co.jhta.vo.Book;

public class BookDaoImpl implements BookDao {
	
	private SqlMapClientTemplate template;
	public void setTemplate(SqlMapClientTemplate template) {
		this.template = template;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAllBooks() {
		return template.queryForList("getAllBooks");
	}
	
	@Override
	public void addBook(Book book) {
		template.insert("addBook", book);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> searchBooks(Book book) {
		return template.queryForList("searchBooks", book);
	}
}
