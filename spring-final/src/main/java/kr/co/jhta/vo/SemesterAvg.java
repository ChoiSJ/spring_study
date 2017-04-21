package kr.co.jhta.vo;

public class SemesterAvg {
	private String semename;
	private int credit1;
	private int credit2;
	private double credit3;
	private int credit4;
	private int grade;
	private int pass1;
	private int pass2;
	private int pass3;
	private int pass4;
	public String getSemename() {
		return semename;
	}
	public int getCredit1() {
		return credit1;
	}
	public int getCredit2() {
		return credit2;
	}
	public double getCredit3() {
		return credit3;
	}
	public int getCredit4() {
		return credit4;
	}
	public int getGrade() {
		return grade;
	}
	public int getPass1() {
		return pass1;
	}
	public int getPass2() {
		return pass2;
	}
	public int getPass3() {
		return pass3;
	}
	public int getPass4() {
		return pass4;
	}
	public void setSemename(String semename) {
		this.semename = semename;
	}
	public void setCredit1(int credit1) {
		this.credit1 = credit1;
	}
	public void setCredit2(int credit2) {
		this.credit2 = credit2;
	}
	public void setCredit3(double credit3) {
		this.credit3 = credit3;
	}
	public void setCredit4(int credit4) {
		this.credit4 = credit4;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setPass1(int pass1) {
		this.pass1 = pass1;
	}
	public void setPass2(int pass2) {
		this.pass2 = pass2;
	}
	public void setPass3(int pass3) {
		this.pass3 = pass3;
	}
	public void setPass4(int pass4) {
		this.pass4 = pass4;
	}
	
	@Override
	public String toString() {
		return "SemesterAvg [semename=" + semename + ", credit1=" + credit1 + ", credit2=" + credit2 + ", credit3="
				+ credit3 + ", credit4=" + credit4 + ", grade=" + grade + ", pass1=" + pass1 + ", pass2=" + pass2
				+ ", pass3=" + pass3 + ", pass4=" + pass4 + "]";
	}
	
}
