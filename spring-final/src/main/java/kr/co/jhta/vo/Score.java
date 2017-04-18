package kr.co.jhta.vo;

public class Score {
	private SubjectRegister registerinfo;
	private int no;
	private int credit;
	private String grade;
	private int reportScore;
	private int attScore;
	private int midtermScore;
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
