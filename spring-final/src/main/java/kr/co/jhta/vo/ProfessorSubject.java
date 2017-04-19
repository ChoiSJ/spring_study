package kr.co.jhta.vo;

public class ProfessorSubject {

	private int subjectNo; //과목번호
	private String subjectCode; //과목코드
	private String subjectName; //과목이름
	private String subjectPassd; // 전공 필수/선택
	private String subjectPorfessor;
	private String subjectProfeesorId; //FK
	
	
	public int getSubjectNo() {
		return subjectNo;
	}
	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectPassd() {
		return subjectPassd;
	}
	public void setSubjectPassd(String subjectPassd) {
		this.subjectPassd = subjectPassd;
	}
	public String getSubjectPorfessor() {
		return subjectPorfessor;
	}
	public void setSubjectPorfessor(String subjectPorfessor) {
		this.subjectPorfessor = subjectPorfessor;
	}
	public String getSubjectId() {
		return subjectProfeesorId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectProfeesorId = subjectId;
	}
	
	
	
	
	
	
	
	
}
