package kr.co.jhta.vo;

public class TimeChart {
	private int studentNo;
	private int enrollNo;
	private String enrollTime;
	private String enrollDay;
	private String subjectName;
	private int subjectNo;
	
	public int getSubjectNo() {
		return subjectNo;
	}
	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public int getEnrollNo() {
		return enrollNo;
	}
	public void setEnrollNo(int enrollNo) {
		this.enrollNo = enrollNo;
	}
	public String getEnrollTime() {
		return enrollTime;
	}
	public void setEnrollTime(String enrollTime) {
		this.enrollTime = enrollTime;
	}
	public String getEnrollDay() {
		return enrollDay;
	}
	public void setEnrollDay(String enrollDay) {
		this.enrollDay = enrollDay;
	}
	@Override
	public String toString() {
		return "TimeChart [studentNo=" + studentNo + ", enrollNo=" + enrollNo + ", enrollTime=" + enrollTime
				+ ", enrollDay=" + enrollDay + ", subjectName=" + subjectName + ", subjectNo=" + subjectNo + "]";
	}
	
}