package kr.co.jhta.vo.stu;

import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.SubjectDivision;

public class Enroll {

	private int no;
	private Subject subject;
	private SubjectDivision division;
	private String enrollDay;
	private String enrollTime;
	private int enrollNum;
	private int stuNo;
	private Student student;
	
	
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Enroll() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Enroll(int no, Subject subject, SubjectDivision division, String enrollDay, String enrollTime, int enrollNum,
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

	public String getEnrollTime() {
		return enrollTime;
	}

	public void setEnrollTime(String enrollTime) {
		this.enrollTime = enrollTime;
	}

	@Override
	public String toString() {
		return "Enroll [no=" + no + ", subject=" + subject + ", division=" + division + ", enrollDay=" + enrollDay
				+ ", enrollTime=" + enrollTime + ", enrollNum=" + enrollNum + ", stuNo=" + stuNo + "]";
	}
	
	
}
