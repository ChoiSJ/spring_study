package kr.co.jhta.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Score {
	private SubjectRegister registerinfo;
	private int no;
	private int credit;
	private String grade;
	
	@Min(value=0, message="과제점수는 0점 이상 만 가능합니다.")
	@Max(value=100, message="과제점수는 100점 이하 만 가능합니다.")
	private int reportScore;
	
	@Min(value=0, message="출석점수는 0점 이상 만 가능합니다.")
	@Max(value=100, message="출석점수는 100점 이하 만 가능합니다.")
	private int attScore;
	
	@Min(value=0, message="중간점수는 0점 이상 만 가능합니다.")
	@Max(value=100, message="중간점수는 100점 이하 만 가능합니다.")
	private int midtermScore;
	
	@Min(value=0, message="기말점수는 0점 이상 만 가능합니다.")
	@Max(value=100, message="기말점수는 100점 이하 만 가능합니다.")
	private int endtermScore;
	
	public Score() {
		// TODO Auto-generated constructor stub
	}
	
	public SubjectRegister getRegister() {
		return registerinfo;
	}
	public int getNo() {
		return no;
	}
	public int getCredit() {
		return credit;
	}
	public String getGrade() {
		return grade;
	}
	public int getReportScore() {
		return reportScore;
	}
	public int getAttScore() {
		return attScore;
	}
	public int getMidtermScore() {
		return midtermScore;
	}
	public int getEndtermScore() {
		return endtermScore;
	}
	public void setRegister(SubjectRegister registerinfo) {
		this.registerinfo = registerinfo;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setReportScore(int reportScore) {
		this.reportScore = reportScore;
	}
	public void setAttScore(int attScore) {
		this.attScore = attScore;
	}
	public void setMidtermScore(int midtermScore) {
		this.midtermScore = midtermScore;
	}
	public void setEndtermScore(int endtermScore) {
		this.endtermScore = endtermScore;
	}

	@Override
	public String toString() {
		return "Score [registerinfo=" + registerinfo + ", no=" + no + ", credit=" + credit + ", grade=" + grade
				+ ", reportScore=" + reportScore + ", attScore=" + attScore + ", midtermScore=" + midtermScore
				+ ", endtermScore=" + endtermScore + "]";
	}
	
}
