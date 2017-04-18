package kr.co.jhta.vo.stu;

import java.util.Date;

public class Student {
	
	private int no;
	private String addr1;
	private String addr2;
	private String email;
	private int grade;
	private String ssn;
	private Date enterDate;
	private Date leaveDate;
	private String parentName;
	private String parentPhone;
	private String id;
	private String pwd;
	private String name;
	private String gender;
	private String division;
	private String register;
	private int score;
	private String phone;
	private String professor;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}		
	
	

	public Student(int no, String addr1, String addr2, String email, int grade, String ssn, Date enterDate,
			Date leaveDate, String parentName, String parentPhone, String id, String pwd, String name, String gender,
			String division, String register, int score, String phone, String professor) {
		super();
		this.no = no;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.email = email;
		this.grade = grade;
		this.ssn = ssn;
		this.enterDate = enterDate;
		this.leaveDate = leaveDate;
		this.parentName = parentName;
		this.parentPhone = parentPhone;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.division = division;
		this.register = register;
		this.score = score;
		this.phone = phone;
		this.professor = professor;
	}



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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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
		return "Student [no=" + no + ", addr1=" + addr1 + ", addr2=" + addr2 + ", email=" + email + ", grade=" + grade
				+ ", ssn=" + ssn + ", enterDate=" + enterDate + ", leaveDate=" + leaveDate + ", parentName="
				+ parentName + ", parentPhone=" + parentPhone + ", id=" + id + ", pwd=" + pwd + ", name=" + name
				+ ", gender=" + gender + ", division=" + division + ", register=" + register + ", score=" + score
				+ ", phone=" + phone + "]";
	}
	
	
	
}
