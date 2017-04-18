package kr.co.jhta.vo;

public class Subject {

	private int no;
	private String subjectName;
	private Professor professor;
	private Semester selectNo;
	private int grade;
	private SubjectIsPassed isPassed;
	private SiteMap siteCode;
	private int score;
	private int division;
	private String outline;
	private String reference;
	private String progress;
	
	
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

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
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

	public SubjectIsPassed getIsPassed() {
		return isPassed;
	}

	public void setIsPassed(SubjectIsPassed isPassed) {
		this.isPassed = isPassed;
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

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	@Override
	public String toString() {
		return "Subject [no=" + no + ", subjectName=" + subjectName + ", professor=" + professor + ", selectNo="
				+ selectNo + ", grade=" + grade + ", isPassed=" + isPassed + ", siteCode=" + siteCode + ", score="
				+ score + ", division=" + division + ", outline=" + outline + ", reference=" + reference + ", progress="
				+ progress + "]";
	}

	
	
}
