package kr.co.jhta.vo;

public class Attendance {
	private int attNo;
	private int scoreNo;
	private int count;
	private int attScore;
	
	public int getAttNo() {
		return attNo;
	}
	public int getScoreNo() {
		return scoreNo;
	}
	public int getCount() {
		return count;
	}
	public int getAttScore() {
		return attScore;
	}
	public void setAttNo(int attNo) {
		this.attNo = attNo;
	}
	public void setScoreNo(int scoreNo) {
		this.scoreNo = scoreNo;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setAttScore(int attScore) {
		this.attScore = attScore;
	}
	
	@Override
	public String toString() {
		return "Attendance [attNo=" + attNo + ", scoreNo=" + scoreNo + ", count=" + count + ", attScore=" + attScore
				+ "]";
	}	
	
}
