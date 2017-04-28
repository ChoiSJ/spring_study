package kr.co.jhta.vo;

import org.springframework.web.multipart.MultipartFile;

public class MessageForm {
	
	private String title;
	private String writer;
	private String receiver;
	private String contents;
	private MultipartFile file;
	
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
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	@Override
	public String toString() {
		return "MessageForm [title=" + title + ", writer=" + writer + ", receiver=" + receiver + ", contents=" + contents
				+ ", file=" + file + "]";
	}
}