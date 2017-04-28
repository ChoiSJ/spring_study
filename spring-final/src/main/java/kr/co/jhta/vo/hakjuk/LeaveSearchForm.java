package kr.co.jhta.vo.hakjuk;

public class LeaveSearchForm {
	
	private String register;
	private String division;
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
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "LeaveSearchForm [register=" + register + ", division=" + division + ", sort=" + sort + ", q=" + q + "]";
	}
}
