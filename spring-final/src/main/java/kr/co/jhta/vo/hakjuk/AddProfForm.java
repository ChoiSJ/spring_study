package kr.co.jhta.vo.hakjuk;

public class AddProfForm {
	
	private String name;
	private String register;
	private String id;
	private String pwd;
	private String ssn;
	private String gender;
	private String division;
	private String code;
	private String grade;
	private String forei;
	private String phone;
	private String email;
	private String addr1;
	private String addr2;
	private String addr;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getForei() {
		return forei;
	}
	public void setForei(String forei) {
		this.forei = forei;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "AddProfForm [name=" + name + ", register=" + register + ", id=" + id + ", pwd=" + pwd + ", ssn=" + ssn
				+ ", gender=" + gender + ", division=" + division + ", code=" + code + ", grade=" + grade + ", forei="
				+ forei + ", phone=" + phone + ", email=" + email + ", addr1=" + addr1 + ", addr2=" + addr2 + ", addr="
				+ addr + "]";
	}
	
}
