package kr.co.jhta.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Board {
	private int no;
	private String title;
	private String contents;
	private String writer;
	@JsonFormat(pattern="yyyy/MM/dd")
	private Date regdate;
	private int countView;
	private String category;
	private String fileName;
	private String department;
	private String subjectNo;
	
	
	
	public String getSubjectNo() {
		return subjectNo;
	}
	public void setSubjectNo(String subjectNo) {
		this.subjectNo = subjectNo;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	public int getCountView() {
		return countView;
	}
	public void setCountView(int countView) {
		this.countView = countView;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", contents=" + contents + ", writer=" + writer + ", regdate="
				+ regdate + ", countView=" + countView + ", category=" + category + ", fileName=" + fileName
				+ ", department=" + department + ", subjectNo=" + subjectNo + "]";
	}


}
