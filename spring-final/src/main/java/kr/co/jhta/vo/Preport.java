package kr.co.jhta.vo;

import kr.co.jhta.vo.stu.Enroll;

public class Preport {
	private int no;
	private Enroll enroll;
	private String content;
	private String title;
	private Professor professor;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Enroll getEnroll() {
		return enroll;
	}
	public void setEnroll(Enroll enroll) {
		this.enroll = enroll;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	@Override
	public String toString() {
		return "Preport [no=" + no + ", enroll=" + enroll + ", content=" + content + ", title=" + title + ", professor="
				+ professor + "]";
	}
	
	
}
