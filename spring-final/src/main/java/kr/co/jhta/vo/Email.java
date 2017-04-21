package kr.co.jhta.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Email {
	
	private List<String> address;
	private String title;
	private String contents;
	private MultipartFile file;
	
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
		return "Email [address=" + address + ", title=" + title + ", contents=" + contents + ", file=" + file + "]";
	}
}
