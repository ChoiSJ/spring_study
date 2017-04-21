package kr.co.jhta.vo.hakjuk;


public class StudentSearchForm {
	
	private String register;
	private String division;
	private String grade;
	private String sort;
	private String q;
	
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	@Override
	public String toString() {
		return "StudentSearchForm [register=" + register + ", division=" + division + ", grade=" + grade + ", sort="
				+ sort + ", q=" + q + "]";
	}

}
