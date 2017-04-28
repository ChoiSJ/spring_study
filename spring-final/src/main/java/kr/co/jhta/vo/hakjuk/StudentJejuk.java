package kr.co.jhta.vo.hakjuk;

import java.util.Date;

import kr.co.jhta.vo.stu.Student;

public class StudentJejuk {

	private int no;
	private Student student;
	private String reason;
	private Date disDate;
	
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getDisDate() {
		return disDate;
	}
	public void setDisDate(Date disDate) {
		this.disDate = disDate;
	}
	
	
}
