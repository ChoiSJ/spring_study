package demo3;

public class Score {
	
	private String subject;
	private Grade grade;
	
	public Score() {}
	public Score(String subject, Grade grade) {
		this.subject = subject;
		this.grade = grade;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
}
