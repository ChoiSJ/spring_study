package kr.co.jhta.vo.hakjuk;

import java.util.Date;

import kr.co.jhta.vo.stu.Student;

public class Leave {
	
	private int no;
	private Student student;
	private String code;
	private Date enrollDate;
	private String pass;
	private Date okDate;
	private Date reinDate;
	private String scorePass;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Date getOkDate() {
		return okDate;
	}
	public void setOkDate(Date okDate) {
		this.okDate = okDate;
	}
	public Date getReinDate() {
		return reinDate;
	}
	public void setReinDate(Date reinDate) {
		this.reinDate = reinDate;
	}
	public String getScorePass() {
		return scorePass;
	}
	public void setScorePass(String scorePass) {
		this.scorePass = scorePass;
	}
	@Override
	public String toString() {
		return "Leave [no=" + no + ", student=" + student + ", code=" + code + ", enrollDate=" + enrollDate + ", pass="
				+ pass + ", okDate=" + okDate + ", reinDate=" + reinDate + ", scorePass=" + scorePass + "]";
	}
		
}
	