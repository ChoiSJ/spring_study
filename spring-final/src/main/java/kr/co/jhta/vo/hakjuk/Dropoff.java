package kr.co.jhta.vo.hakjuk;

import java.util.Date;

import kr.co.jhta.vo.stu.Student;

public class Dropoff {
	
	
	private int no;
	private String code;
	private Student student;
	private String pass;
	private Date passDate;
	private Date enrollDate;
	private String reason;
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Date getPassDate() {
		return passDate;
	}
	public void setPassDate(Date passDate) {
		this.passDate = passDate;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	@Override
	public String toString() {
		return "DropOff [no=" + no + ", code=" + code + ", student=" + student + ", pass=" + pass + ", passDate="
				+ passDate + ", enrollDate=" + enrollDate + "]";
	}
}
