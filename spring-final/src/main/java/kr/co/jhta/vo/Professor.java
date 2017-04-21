package kr.co.jhta.vo;

import java.util.Date;

public class Professor {
	private int no;
	private String id;
	private String name;
	private String gender;
	private SiteMap sitemap;
	private String code;
	private String division;
	private String pwd;
	private String register;
	private String phone;
	private String addr;
	private String email;
	private String grade;
	private String ssn;
	private String forei;
	private Date entrydate;
	private Date leavedate;
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public SiteMap getSitemap() {
		return sitemap;
	}
	public void setSitemap(SiteMap sitemap) {
		this.sitemap = sitemap;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getForei() {
		return forei;
	}
	public void setForei(String forei) {
		this.forei = forei;
	}
	public Date getEntrydate() {
		return entrydate;
	}
	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}
	public Date getLeavedate() {
		return leavedate;
	}
	public void setLeavedate(Date leavedate) {
		this.leavedate = leavedate;
	}
	@Override
	public String toString() {
		return "Professor [no=" + no + ", id=" + id + ", name=" + name + ", gender=" + gender + ", sitemap=" + sitemap
				+ ", code=" + code + ", division=" + division + ", pwd=" + pwd + ", register=" + register + ", phone="
				+ phone + ", addr=" + addr + ", email=" + email + ", grade=" + grade + ", ssn=" + ssn + ", forei="
				+ forei + ", entrydate=" + entrydate + ", leavedate=" + leavedate + "]";
	}
	
}