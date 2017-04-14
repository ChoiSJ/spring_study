package kr.co.jhta.vo;

import java.util.Date;

public class Review {
	private int no;
	private int groupNo;	
	private String contents;
	private String writer;
	private Date regdate;

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Review [no=" + no + ", groupNo=" + groupNo + ", contents=" + contents + ", writer=" + writer
				+ ", regdate=" + regdate + "]";
	}
	
}
