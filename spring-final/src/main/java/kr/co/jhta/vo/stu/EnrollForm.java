package kr.co.jhta.vo.stu;

public class EnrollForm {
	private int no;
	private int subjectNo;
	private String enrollDay;
	private String enrollTime;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public int getSubjectNo() {
		return subjectNo;
	}
	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}
	public String getEnrollDay() {
		return enrollDay;
	}
	public void setEnrollDay(String enrollDay) {
		this.enrollDay = enrollDay;
	}
	public String getEnrollTime() {
		return enrollTime;
	}
	public void setEnrollTime(String enrollTime) {
		this.enrollTime = enrollTime;
	}
	@Override
	public String toString() {
		return "EnrollForm [no=" + no + ", subjectNo=" + subjectNo + ", enrollDay=" + enrollDay + ", enrollTime="
				+ enrollTime + "]";
	}

	
	
}
