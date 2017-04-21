package kr.co.jhta.vo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MessageForm {
	
	private int no;
	private String title;
	private String writer;
	private List<String> reciver;
	private String contents;
	private boolean isCheck;
	private MultipartFile file;
	private Date sendTime;
	private Date checkTime;
	
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public List<String> getReciver() {
		return reciver;
	}
	public void setReciver(List<String> reciver) {
		this.reciver = reciver;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public boolean isCheck() {
		return isCheck;
	}
	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
}