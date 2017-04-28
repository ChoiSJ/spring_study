package kr.co.jhta.vo.stu;

import java.util.Date;

public class Student {
	
	private int no;
	private String addr1;
	private String addr2;
	private String addr3;
	private int zipcode;
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
	private int remainLeave;
	private String tName;
	private String cName;	
	private int maxOneScore;
	private int nowScore;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getRemainLeave() {
		return remainLeave;
	}
	public void setRemainLeave(int remainLeave) {
		this.remainLeave = remainLeave;
	}

	
	
	public String gettName() {
		return tName;
	}


	public void settName(String tName) {
		this.tName = tName;
	}


	public String getcName() {
		return cName;
	}


	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getMaxOneScore() {
		return maxOneScore;
	}

	public void setMaxOneScore(int maxOneScore) {
		this.maxOneScore = maxOneScore;
	}

	public int getNowScore() {
		return nowScore;
	}

	public void setNowScore(int nowScore) {
		this.nowScore = nowScore;
	}

	public String getAddr3() {
		return addr3;
	}

	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", addr1=" + addr1 + ", addr2=" + addr2 + ", addr3=" + addr3 + ", zipcode="
				+ zipcode + ", email=" + email + ", grade=" + grade + ", ssn=" + ssn + ", enterDate=" + enterDate
				+ ", leaveDate=" + leaveDate + ", parentName=" + parentName + ", parentPhone=" + parentPhone + ", id="
				+ id + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender + ", division=" + division
				+ ", register=" + register + ", score=" + score + ", phone=" + phone + ", professor=" + professor
				+ ", remainLeave=" + remainLeave + ", tName=" + tName + ", cName=" + cName + ", maxOneScore="
				+ maxOneScore + ", nowScore=" + nowScore + "]";
	}	
	
}
