package kr.co.jhta.rest.vo;

import java.util.Date;

public class Todo {
	
	private int no;
	private String title;
	private Date eventDate;
	private String description;
	private String completed;
	private User user;	// tb_todo 의 user_no 에 대응
	private String mapFilename;		// 약도파일명 - 웹에서 봄
	private String attachFilename;	// 첨부파일명 - 웹에서 못봄
	private Date regdate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCompleted() {
		return completed;
	}
	public void setCompleted(String completed) {
		this.completed = completed;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMapFilename() {
		return mapFilename;
	}
	public void setMapFilename(String mapFilename) {
		this.mapFilename = mapFilename;
	}
	public String getAttachFilename() {
		return attachFilename;
	}
	public void setAttachFilename(String attachFilename) {
		this.attachFilename = attachFilename;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
