package kr.co.jhta.vo;

import java.util.Date;

public class Report {
	
	private String reportTitle;
	private Date reportDeadline;
	private Date reportDate;
	private String reportPublic;
	private int reportScore;
	private int scoreNo;
	
	public String getReportTitle() {
		return reportTitle;
	}
	public Date getReportDeadline() {
		return reportDeadline;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public String getReportPublic() {
		return reportPublic;
	}
	public int getReportScore() {
		return reportScore;
	}
	public int getScoreNo() {
		return scoreNo;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	public void setReportDeadline(Date reportDeadline) {
		this.reportDeadline = reportDeadline;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public void setReportPublic(String reportPublic) {
		this.reportPublic = reportPublic;
	}
	public void setReportScore(int reportScore) {
		this.reportScore = reportScore;
	}
	public void setScoreNo(int scoreNo) {
		this.scoreNo = scoreNo;
	}
	
}
