package kr.co.jhta.vo.stu;

import kr.co.jhta.vo.Score;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.SubjectDivision;

public class Enroll {

	private int no;
	private Subject subject;
	private SubjectDivision division;
	private String enrollDay;
	private int enrollTime;
	private int enrollNum;
	private int stuNo;
	
	public Enroll() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Enroll(int no, Subject subject, SubjectDivision division, String enrollDay, int enrollTime, int enrollNum,
			int stuNo) {
		super();
		this.no = no;
		this.subject = subject;
		this.division = division;
		this.enrollDay = enrollDay;
		this.enrollTime = enrollTime;
		this.enrollNum = enrollNum;
		this.stuNo = stuNo;
	}



	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public int getEnrollNum() {
		return enrollNum;
	}

	public void setEnrollNum(int enrollNum) {
		this.enrollNum = enrollNum;
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
	public SubjectDivision getDivision() {
		return division;
	}
	public void setDivision(SubjectDivision division) {
		this.division = division;
	}
	public String getEnrollDay() {
		return enrollDay;
	}
	public void setEnrollDay(String enrollDay) {
		this.enrollDay = enrollDay;
	}
	public int getEnrollTime() {
		return enrollTime;
	}
	public void setEnrollTime(int enrollTime) {
		this.enrollTime = enrollTime;
	}
	
}
