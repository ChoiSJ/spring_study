package kr.co.jhta.vo;

import java.util.Date;

public class Board {
	
	private int id;
	private String title;
	private String writer;
	private String contents;
	private Date regdate;
	
	public Board() {}
	public Board(String title, String writer, String contents) {
		this.title = title;
		this.writer = writer;
		this.contents = contents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", writer=" + writer + ", contents=" + contents + ", regdate="
				+ regdate + "]";
	}
}
