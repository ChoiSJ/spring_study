package kr.co.jhta.vo;

public class SubjectEditForm {

	private int no;
	private String subjectName;
	private int limitStu;
	private SubjectIsPassed passed;
	private int grade;
	private Professor professor;
	private int score; 
	
	public SubjectEditForm() {
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

	public int getLimitStu() {
		return limitStu;
	}

	public void setLimitStu(int limitStu) {
		this.limitStu = limitStu;
	}

	public SubjectIsPassed getPassed() {
		return passed;
	}

	public void setPassed(SubjectIsPassed passed) {
		this.passed = passed;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
