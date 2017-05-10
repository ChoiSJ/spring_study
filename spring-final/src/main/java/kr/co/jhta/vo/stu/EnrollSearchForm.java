package kr.co.jhta.vo.stu;

public class EnrollSearchForm {

	private String option1;
	private String dept;
	private String selectMajor;
	private String searchInput;

	public EnrollSearchForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getSelectMajor() {
		return selectMajor;
	}
	public void setSelectMajor(String selectMajor) {
		this.selectMajor = selectMajor;
	}
	public String getSearchInput() {
		return searchInput;
	}
	public void setSearchInput(String searchInput) {
		this.searchInput = searchInput;
	}
	@Override
	public String toString() {
		return "EnrollSearchForm [option1=" + option1 + ", dept=" + dept + ", selectMajor=" + selectMajor
				+ ", searchInput=" + searchInput + "]";
	}
		
}
