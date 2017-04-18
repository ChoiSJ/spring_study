package kr.co.jhta.vo.stu;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class StudentForm {
	
	@NotNull
	private String addr1;
	
	@NotNull
	private String addr2;
	
	@NotNull
	@Pattern(regexp="[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}", message="올바른 이메일 형식을 입력하세요")
	private String email;
	
	private Date leaveDate;
	
	@Length(max=14, message="000-0000-0000 형식입니다.")
	@Pattern(regexp="\\d{2,3}-\\d{3,4}-\\d{4}", message="올바른 형식을 입력하세요(000-0000-0000)")
	private String parentPhone;
	
	@NotNull
	private String pwd;
	
	@NotNull
	@Length(max=14, message="000-0000-0000 형식입니다.")
	@Pattern(regexp="\\d{2,3}-\\d{3,4}-\\d{4}", message="올바른 형식을 입력하세요(000-0000-0000)")
	private String phone;
	
	private int no;
	private int grade;
	private String ssn;
	private Date enterDate;
	private String parentName;
	private String id;
	private String name;
	private String gender;
	private String division;
	private String register;
	private int score;
	private String professor;
	
	public StudentForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StudentForm(String addr1, String addr2, String email, Date leaveDate, String parentPhone, String pwd,
			String phone, int no, int grade, String ssn, Date enterDate, String parentName, String id, String name,
			String gender, String division, String register, int score, String professor) {
		super();
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.email = email;
		this.leaveDate = leaveDate;
		this.parentPhone = parentPhone;
		this.pwd = pwd;
		this.phone = phone;
		this.no = no;
		this.grade = grade;
		this.ssn = ssn;
		this.enterDate = enterDate;
		this.parentName = parentName;
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.division = division;
		this.register = register;
		this.score = score;
		this.professor = professor;
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
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getParentPhone() {
		return parentPhone;
	}
	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
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
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
}
