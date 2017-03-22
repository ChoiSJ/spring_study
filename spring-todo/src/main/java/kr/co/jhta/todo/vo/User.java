package kr.co.jhta.todo.vo;

import java.util.Date;

public class User {
	
	private int no;
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private int completedTodo;
	private int uncompletedTodo;
	private Date regdate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	public int getCompletedTodo() {
		return completedTodo;
	}
	public void setCompletedTodo(int completedTodo) {
		this.completedTodo = completedTodo;
	}
	public int getUncompletedTodo() {
		return uncompletedTodo;
	}
	public void setUncompletedTodo(int uncompletedTodo) {
		this.uncompletedTodo = uncompletedTodo;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
