package kr.co.jhta.vo.hakjuk;

import java.util.Date;

import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.stu.Student;

public class Reinstatement {
	
	private int no;
	private String code;
	private Student student;
	private Date reinDate; 
	private String pass;
	private Date passDate;
	private Date enrollDate; 
	private Leave leave;
	
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
	public Date getReinDate() {
		return reinDate;
	}
	public void setReinDate(Date reinDate) {
		this.reinDate = reinDate;
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
	public Leave getLeave() {
		return leave;
	}
	public void setLeave(Leave leave) {
		this.leave = leave;
	}
	@Override
	public String toString() {
		return "Reinstatement [no=" + no + ", code=" + code + ", student=" + student + ", reinDate=" + reinDate
				+ ", pass=" + pass + ", passDate=" + passDate + ", enrollDate=" + enrollDate + ", leave=" + leave + "]";
	}
}
