package kr.co.jhta.vo.hakjuk;

import java.util.Date;

import kr.co.jhta.vo.stu.Student;

public class JejukList {

	private int no;
	private String id;
	private String division;
	private Date enterDate;
	private int grade;
	private String name;
	private String phone;
	private String email;
	private String register;
	private String reason;
	private Date disDate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getDivision() {
		return division;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public Date getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
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
