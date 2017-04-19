package kr.co.jhta.vo.stu;

import kr.co.jhta.vo.Score;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.SubjectDivision;

public class Regisubject {

	private int no;
	private int grade;
	private int maxGrade;
	private Subject subject;
	private SubjectDivision division;
	private Student student;
	private Score score;
	private Enroll enroll;
	
	public Regisubject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Regisubject(int no, int grade, int maxGrade, Subject subject, SubjectDivision division, Student student,
			Enroll enroll, Score score) {
		super();
		this.no = no;
		this.grade = grade;
		this.maxGrade = maxGrade;
		this.subject = subject;
		this.division = division;
		this.student = student;
		this.enroll = enroll;
		this.score = score;
	}
	
	public void setScore(Score score) {
		this.score = score;
	}

	public Score getScore() {
		return score;
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

	public int getMaxGrade() {
		return maxGrade;
	}

	public void setMaxGrade(int maxGrade) {
		this.maxGrade = maxGrade;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public SubjectDivision getDivision() {
		return division;
	}

	public void setDivision(SubjectDivision division) {
		this.division = division;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Enroll getEnroll() {
		return enroll;
	}

	public void setEnroll(Enroll enroll) {
		this.enroll = enroll;
	}

	@Override
	public String toString() {
		return "Regisubject [no=" + no + ", grade=" + grade + ", maxGrade=" + maxGrade + ", subject=" + subject
				+ ", division=" + division + ", student=" + student + ", score=" + score + ", enroll=" + enroll + "]";
	}

}
