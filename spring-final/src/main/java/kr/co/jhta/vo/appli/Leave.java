package kr.co.jhta.vo.appli;

import java.util.Calendar;
import java.util.Date;

public class Leave {
	
	private int no;
	private int stuNo;
	private String code;
	private Date enrollDate;
	private String pass;
	private Date okayDate;
	private Date reinDate;
	private String scorePass;
	private String cName;
	
	public Leave() {}

	public Leave(int no, int stuNo, String code, Date enrollDate, String pass, Date okayDate, Date reinDate,
			String scorePass, String cName) {
		super();
		this.no = no;
		this.stuNo = stuNo;
		this.code = code;
		this.enrollDate = enrollDate;
		this.pass = pass;
		this.okayDate = okayDate;
		this.reinDate = reinDate;
		this.scorePass = scorePass;
		this.cName = cName;
	}



	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Date getOkayDate() {
		return okayDate;
	}
	public void setOkayDate(Date okayDate) {
		this.okayDate = okayDate;
	}
	public Date getReinDate() {
		return reinDate;
	}
	public void setReinDate(Date reinDate) {
		this.reinDate = reinDate;
	}
	public String getScorePass() {
		return scorePass;
	}
	public void setScorePass(String scorePass) {
		this.scorePass = scorePass;
	}
	
	public int getPeriod() {
		Calendar c = Calendar.getInstance();
		c.setTime(enrollDate);
		int month = c.get(Calendar.MONTH) + 1;
		
		if (month <7) {
			return 1;
		} else {
			return 2;
		}
		
	}
	
	public int getYear() {
		Calendar c = Calendar.getInstance();
		c.setTime(enrollDate);
		return c.get(Calendar.YEAR);		
	}
	
	
	
	public String getcName() {
		return cName;
	}



	public void setcName(String cName) {
		this.cName = cName;
	}



	@Override
	public String toString() {
		return "Leave [no=" + no + ", stuNo=" + stuNo + ", code=" + code + ", enrollDate=" + enrollDate + ", pass="
				+ pass + ", okayDate=" + okayDate + ", reinDate=" + reinDate + ", scorePass=" + scorePass + "]";
	}

}
