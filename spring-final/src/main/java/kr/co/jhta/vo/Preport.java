package kr.co.jhta.vo;

import java.util.Date;

import kr.co.jhta.vo.stu.Enroll;

public class Preport {
	private int no;
	private Enroll enroll;
	private String content;
	private String title;
	private Professor professor;
	private Subject subject;
	private Date prost;
	private Date proend;
	private String upfile;
	private Score score;
	
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public String getUpfile() {
		return upfile;
	}
	public void setUpfile(String upfile) {
		this.upfile = upfile;
	}
	public Date getProst() {
		return prost;
	}
	public void setProst(Date prost) {
		this.prost = prost;
	}
	public Date getProend() {
		return proend;
	}
	public void setProend(Date proend) {
		this.proend = proend;
	}
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
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Preport [no=" + no + ", enroll=" + enroll + ", content=" + content + ", title=" + title + ", professor="
				+ professor + ", subject=" + subject + ", prost=" + prost + ", proend=" + proend + ", upfile=" + upfile
				+ ", score=" + score + "]";
	}
	
	
	
	
}
