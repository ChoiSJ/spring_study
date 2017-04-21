package kr.co.jhta.vo;

public class LectureEvaluationSheet {

	private String professorId;
	private String contents;
	private int subjectNo;
	private String register;
	
	
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getProfessorId() {
		return professorId;
	}
	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getSubjectNo() {
		return subjectNo;
	}
	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}
	
	
}
