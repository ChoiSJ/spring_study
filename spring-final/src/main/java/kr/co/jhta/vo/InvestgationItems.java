package kr.co.jhta.vo;

import java.util.List;

public class InvestgationItems {

	private String professorId;	
	private List<String> contents;

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
