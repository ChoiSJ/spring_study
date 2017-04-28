package kr.co.jhta.vo;

public class MakeupLessonAll {
	
	private String professorId;
	private int subjectNo;
	private String majorCode;
	private String subjectName;
	private String professorName;
	private String supplementLectureCheck;
	private String professorNumber;
	private String majorOption;
	private int majorScore;
	private int subjectLectureNumber;
	private String subjectDate;
	private String subjectTime;
	private int supplementLectureNo;
	private String makeupLessonRegister;
	
	@Override
	public String toString() {
		return "MakeupLessonAll [professorId=" + professorId + ", subjectNo=" + subjectNo + ", majorCode=" + majorCode
				+ ", subjectName=" + subjectName + ", professorName=" + professorName + ", supplementLectureCheck="
				+ supplementLectureCheck + ", professorNumber=" + professorNumber + ", majorOption=" + majorOption
				+ ", majorScore=" + majorScore + ", subjectLectureNumber=" + subjectLectureNumber + ", subjectDate="
				+ subjectDate + ", subjectTime=" + subjectTime + ", supplementLectureNo=" + supplementLectureNo
				+ ", makeupLessonRegister=" + makeupLessonRegister + "]";
	}
	
	public String getProfessorId() {
		return professorId;
	}
	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}
	public int getSubjectNo() {
		return subjectNo;
	}
	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}
	public String getMajorCode() {
		return majorCode;
	}
	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getSupplementLectureCheck() {
		return supplementLectureCheck;
	}
	public void setSupplementLectureCheck(String supplementLectureCheck) {
		this.supplementLectureCheck = supplementLectureCheck;
	}
	public String getProfessorNumber() {
		return professorNumber;
	}
	public void setProfessorNumber(String professorNumber) {
		this.professorNumber = professorNumber;
	}
	public String getMajorOption() {
		return majorOption;
	}
	public void setMajorOption(String majorOption) {
		this.majorOption = majorOption;
	}
	public int getMajorScore() {
		return majorScore;
	}
	public void setMajorScore(int majorScore) {
		this.majorScore = majorScore;
	}
	public int getSubjectLectureNumber() {
		return subjectLectureNumber;
	}
	public void setSubjectLectureNumber(int subjectLectureNumber) {
		this.subjectLectureNumber = subjectLectureNumber;
	}
	public String getSubjectDate() {
		return subjectDate;
	}
	public void setSubjectDate(String subjectDate) {
		this.subjectDate = subjectDate;
	}
	public String getSubjectTime() {
		return subjectTime;
	}
	public void setSubjectTime(String subjectTime) {
		this.subjectTime = subjectTime;
	}
	public int getSupplementLectureNo() {
		return supplementLectureNo;
	}
	public void setSupplementLectureNo(int supplementLectureNo) {
		this.supplementLectureNo = supplementLectureNo;
	}
	public String getMakeupLessonRegister() {
		return makeupLessonRegister;
	}
	public void setMakeupLessonRegister(String makeupLessonRegister) {
		this.makeupLessonRegister = makeupLessonRegister;
	}
	
	
}
