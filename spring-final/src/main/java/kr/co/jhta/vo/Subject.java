package kr.co.jhta.vo;

public class Subject {

	private int no;
	private String subjectName;
	private Professor professor;
	private Semester selectNo;
	private int grade;
	private SubjectIsPassed passed;
	private SiteMap siteCode;
	private int score;
	private int division;
	private int limitStu;

	public Subject() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Semester getSelectNo() {
		return selectNo;
	}

	public void setSelectNo(Semester selectNo) {
		this.selectNo = selectNo;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public SubjectIsPassed getPassed() {
		return passed;
	}

	public void setPassed(SubjectIsPassed passed) {
		this.passed = passed;
	}

	public SiteMap getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(SiteMap siteCode) {
		this.siteCode = siteCode;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
	}

	public int getLimitStu() {
		return limitStu;
	}

	public void setLimitStu(int limitStu) {
		this.limitStu = limitStu;
	}

	public Subject(int no, String subjectName, Professor professor, Semester selectNo, int grade,
			SubjectIsPassed passed, SiteMap siteCode, int score, int division, int limitStu) {
		super();
		this.no = no;
		this.subjectName = subjectName;
		this.professor = professor;
		this.selectNo = selectNo;
		this.grade = grade;
		this.passed = passed;
		this.siteCode = siteCode;
		this.score = score;
		this.division = division;
		this.limitStu = limitStu;
	}

	@Override
	public String toString() {
		return "Subject [no=" + no + ", subjectName=" + subjectName + ", professor=" + professor + ", selectNo="
				+ selectNo + ", grade=" + grade + ", passed=" + passed + ", siteCode=" + siteCode + ", score=" + score
				+ ", division=" + division + ", limitStu=" + limitStu + "]";
	}

}
