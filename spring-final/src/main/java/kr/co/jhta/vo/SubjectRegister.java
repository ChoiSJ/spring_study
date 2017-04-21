package kr.co.jhta.vo;

import kr.co.jhta.vo.stu.Enroll;

public class SubjectRegister {
	
	private Enroll enroll;
	private int regiNo;
	private int stuNo;
	private int jNo;
	private int grade;
	private int maxgrade;
	
	
	
	public Enroll getEnroll() {
		return enroll;
	}
	public void setEnroll(Enroll enroll) {
		this.enroll = enroll;
	}
	public int getRegiNo() {
		return regiNo;
	}
	public void setRegiNo(int regiNo) {
		this.regiNo = regiNo;
	}
	public int getStuNo() {
		return stuNo;
	}
	public int getjNo() {
		return jNo;
	}
	public int getGrade() {
		return grade;
	}
	public int getMaxgrade() {
		return maxgrade;
	}
	
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public void setjNo(int jNo) {
		this.jNo = jNo;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setMaxgrade(int maxgrade) {
		this.maxgrade = maxgrade;
	}
	@Override
	public String toString() {
		return "SubjectRegister [register=" + regiNo + ", stuNo=" + stuNo + ", jNo=" + jNo + ", grade=" + grade
				+ ", maxgrade=" + maxgrade + "]";
	}
	
	
}
