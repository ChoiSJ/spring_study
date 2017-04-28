package kr.co.jhta.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class PreportForm {
	private int enrollno;
	private int profno;
	private String title;
	private String content;
	private Date prost;
	private Date proend;
	private String upfile;
	private MultipartFile file;
	
	
	
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getUpfile() {
		return upfile;
	}
	public void setUpfile(String upfile) {
		this.upfile = upfile;
	}
	public Date getProst() {
		return prost;
	}
	public void setProst(Date prost) {
		this.prost = prost;
	}
	public Date getProend() {
		return proend;
	}
	public void setProend(Date proend) {
		this.proend = proend;
	}
	public int getEnrollno() {
		return enrollno;
	}
	public void setEnrollno(int enrollno) {
		this.enrollno = enrollno;
	}
	public int getProfno() {
		return profno;
	}
	public void setProfno(int profno) {
		this.profno = profno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "PreportForm [enrollno=" + enrollno + ", profno=" + profno + ", title=" + title + ", content=" + content
				+ ", prost=" + prost + ", proend=" + proend + "]";
	}
	
	
	
	
}
