package kr.co.jhta.vo;

import kr.co.jhta.vo.stu.Student;

public class Scorelist {
	
	private int no;
	private Student student;
	private Subject subject;
	private Score score;
	private Attendance att;
	
	public void setAtt(Attendance att) {
		this.att = att;
	}
	public Attendance getAtt() {
		return att;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public Score getScore() {
		return score;
	}
	public int getNo() {
		return no;
	}
	public Student getStudent() {
		return student;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		return "Scorelist [no=" + no + ", student=" + student + ", subject=" + subject + "]";
	}
	
}
