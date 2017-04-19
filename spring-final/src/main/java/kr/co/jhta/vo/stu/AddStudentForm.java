package kr.co.jhta.vo.stu;

public class AddStudentForm {
	
	private int no;
	private String addr1;
	private String addr2;
	private int grade;
	private String ssn;
	private String parentName;
	private String parentPhone;
	private String name;
	private String gender;
	private String division;
	private String register;
	private String phone;
	private String professor;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getParentPhone() {
		return parentPhone;
	}
	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
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
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
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
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	@Override
	public String toString() {
		return "AddStudentForm [no=" + no + ", addr1=" + addr1 + ", addr2=" + addr2 + ", grade=" + grade + ", ssn="
				+ ssn + ", parentName=" + parentName + ", parentPhone=" + parentPhone + ", name=" + name + ", gender="
				+ gender + ", division=" + division + ", register=" + register + ", phone=" + phone + ", professor="
				+ professor + "]";
	}
	
}




