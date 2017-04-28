package kr.co.jhta.vo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Message {
	
	private int no;
	private String title;
	private String writer;
	private String writerName;
	private String receiver;
	private String receiverName;
	private String contents;
	private char isCheck;
	private MultipartFile file;
	private String filename;
	private Date sendTime;
	private Date checkTime;
	private char isDeletedBySender;
	private char isDeletedByReceiver;
	
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
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public char getIsCheck() {
		return isCheck;
	}
	public void setIsCheck(char isCheck) {
		this.isCheck = isCheck;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
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
	public char getIsDeletedBySender() {
		return isDeletedBySender;
	}
	public void setIsDeletedBySender(char isDeletedBySender) {
		this.isDeletedBySender = isDeletedBySender;
	}
	public char getIsDeletedByReceiver() {
		return isDeletedByReceiver;
	}
	public void setIsDeletedByReceiver(char isDeletedByReceiver) {
		this.isDeletedByReceiver = isDeletedByReceiver;
	}
}
