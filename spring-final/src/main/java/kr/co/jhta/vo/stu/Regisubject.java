package kr.co.jhta.vo.stu;

import kr.co.jhta.vo.Score;
import kr.co.jhta.vo.Subject;

public class Regisubject {

	private int no;
	private Subject subject;
	private Student student;
	private Score score;
	private Enroll enroll;
	
	public Regisubject() {
		super();
		// TODO Auto-generated constructor stub
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

	public void setNo(int no) {
		this.no = no;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}


	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Enroll getEnroll() {
		return enroll;
	}

	public void setEnroll(Enroll enroll) {
		this.enroll = enroll;
	}
	
}
