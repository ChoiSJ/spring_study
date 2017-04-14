package kr.co.jhta.vo;

import java.util.Date;

public class StudentStatus {
	
	private int no;
	private String period;
	private String category;
	private String isApprove;
	private String reason;
	private Date regdate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIsApprove() {
		return isApprove;
	}
	public void setIsApprove(String isApprove) {
		this.isApprove = isApprove;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
