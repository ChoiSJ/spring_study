package kr.co.jhta.vo.hakjuk;

public class ReinForm {
	
	private String division;
	private String sort;
	private String q;
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
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
		return "ReinForm [division=" + division + ", sort=" + sort + ", q=" + q + "]";
	}
}
