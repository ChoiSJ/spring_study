package kr.co.jhta.vo;

import java.util.List;

public class InvestgationItems {

	private String professorId;	
	private List<String> contents;
	private int subjectNo;
	private String register;
	
	
	

	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public int getSubjectNo() {
		return subjectNo;
	}
	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}
	public String getProfessorId() {
		return professorId;
	}
	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}
	public List<String> getContents() {
		return contents;
	}
	public void setContents(List<String> contents) {
		this.contents = contents;
	}
}
