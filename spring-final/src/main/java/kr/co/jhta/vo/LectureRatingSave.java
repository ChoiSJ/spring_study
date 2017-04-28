package kr.co.jhta.vo;

public class LectureRatingSave {

	private int scoreNo;
	private String studentId;
	private int ratingScore;
	private int investSubject;
	
	@Override
	public String toString() {
		return "LectureRatingSave [subjectNo=" + scoreNo + ", studentId=" + studentId + ", Score=" + ratingScore
				+ ", investSubject=" + investSubject + "]";
	}

	public int getScoreNo() {
		return scoreNo;
	}

	public void setScoreNo(int scoreNo) {
		this.scoreNo = scoreNo;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getRatingScore() {
		return ratingScore;
	}

	public void setRatingScore(int ratingScore) {
		this.ratingScore = ratingScore;
	}

	public int getInvestSubject() {
		return investSubject;
	}

	public void setInvestSubject(int investSubject) {
		this.investSubject = investSubject;
	}
	
}
