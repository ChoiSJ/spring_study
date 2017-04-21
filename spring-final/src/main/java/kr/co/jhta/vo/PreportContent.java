package kr.co.jhta.vo;

import kr.co.jhta.vo.stu.Student;

public class PreportContent {
	private int no;
	private Preport report;
	private Student student;
	private String title;
	private String content;
	private String file;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Preport getReport() {
		return report;
	}
	public void setReport(Preport report) {
		this.report = report;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
}
