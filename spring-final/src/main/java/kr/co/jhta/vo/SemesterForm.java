package kr.co.jhta.vo;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class SemesterForm {
	
	private int no;
	
	//@NotNull
	//@NotBlank
	private String semeSelect;
	
	//@Future
	//@NotNull
	private Date termStart;
	
	//@Future
	//@NotNull
	private Date termEnd;
	
	//@Future
	//@NotNull
	private Date enrollTermStart;
	
	//@Future
	//@NotNull
	private Date enrollTermEnd;
	
	//@Future
	//@NotNull
	private Date enrollEditTermStart;
	
	//@Future
	//@NotNull
	private Date enrollEditTermEnd;
	
	//@Future
	//@NotNull
	private Date applyTermStart;
	
	//@Future
	//@NotNull
	private Date applyTermEnd;
	
	//@Future
	//@NotNull
	private Date evalTermStart;
	
	//@Future
	//@NotNull
	private Date evalTermEnd;
	
	//@Future
	//@NotNull
	private Date gradeTermStart;
	
	//@Future
	//@NotNull
	private Date gradeTermEnd;
	
	//@Future
	//@NotNull
	private Date appealTermStart;
	
	//@Future
	//@NotNull
	private Date appealTermEnd;
	
	//@Future
	//@NotNull
	private Date gradeEditTermStart;
	
	//@Future
	//@NotNull
	private Date gradeEditTermEnd;
	
	//@Future
	@NotNull
	private Date courseTermStart;
	
	//@Future
	//@NotNull
	private Date courseTermEnd;

	
	
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSemeSelect() {
		return semeSelect;
	}

	public void setSemeSelect(String semeSelect) {
		this.semeSelect = semeSelect;
	}

	public Date getTermStart() {
		return termStart;
	}

	public void setTermStart(Date termStart) {
		this.termStart = termStart;
	}

	public Date getTermEnd() {
		return termEnd;
	}

	public void setTermEnd(Date termEnd) {
		this.termEnd = termEnd;
	}

	public Date getEnrollTermStart() {
		return enrollTermStart;
	}

	public void setEnrollTermStart(Date enrollTermStart) {
		this.enrollTermStart = enrollTermStart;
	}

	public Date getEnrollTermEnd() {
		return enrollTermEnd;
	}

	public void setEnrollTermEnd(Date enrollTermEnd) {
		this.enrollTermEnd = enrollTermEnd;
	}

	public Date getEnrollEditTermStart() {
		return enrollEditTermStart;
	}

	public void setEnrollEditTermStart(Date enrollEditTermStart) {
		this.enrollEditTermStart = enrollEditTermStart;
	}

	public Date getEnrollEditTermEnd() {
		return enrollEditTermEnd;
	}

	public void setEnrollEditTermEnd(Date enrollEditTermEnd) {
		this.enrollEditTermEnd = enrollEditTermEnd;
	}

	public Date getApplyTermStart() {
		return applyTermStart;
	}

	public void setApplyTermStart(Date applyTermStart) {
		this.applyTermStart = applyTermStart;
	}

	public Date getApplyTermEnd() {
		return applyTermEnd;
	}

	public void setApplyTermEnd(Date applyTermEnd) {
		this.applyTermEnd = applyTermEnd;
	}

	public Date getEvalTermStart() {
		return evalTermStart;
	}

	public void setEvalTermStart(Date evalTermStart) {
		this.evalTermStart = evalTermStart;
	}

	public Date getEvalTermEnd() {
		return evalTermEnd;
	}

	public void setEvalTermEnd(Date evalTermEnd) {
		this.evalTermEnd = evalTermEnd;
	}

	public Date getGradeTermStart() {
		return gradeTermStart;
	}

	public void setGradeTermStart(Date gradeTermStart) {
		this.gradeTermStart = gradeTermStart;
	}

	public Date getGradeTermEnd() {
		return gradeTermEnd;
	}

	public void setGradeTermEnd(Date gradeTermEnd) {
		this.gradeTermEnd = gradeTermEnd;
	}

	public Date getAppealTermStart() {
		return appealTermStart;
	}

	public void setAppealTermStart(Date appealTermStart) {
		this.appealTermStart = appealTermStart;
	}

	public Date getAppealTermEnd() {
		return appealTermEnd;
	}

	public void setAppealTermEnd(Date appealTermEnd) {
		this.appealTermEnd = appealTermEnd;
	}

	public Date getGradeEditTermStart() {
		return gradeEditTermStart;
	}

	public void setGradeEditTermStart(Date gradeEditTermStart) {
		this.gradeEditTermStart = gradeEditTermStart;
	}

	public Date getGradeEditTermEnd() {
		return gradeEditTermEnd;
	}

	public void setGradeEditTermEnd(Date gradeEditTermEnd) {
		this.gradeEditTermEnd = gradeEditTermEnd;
	}

	public Date getCourseTermStart() {
		return courseTermStart;
	}

	public void setCourseTermStart(Date courseTermStart) {
		this.courseTermStart = courseTermStart;
	}

	public Date getCourseTermEnd() {
		return courseTermEnd;
	}

	public void setCourseTermEnd(Date courseTermEnd) {
		this.courseTermEnd = courseTermEnd;
	}
	
	
	
	
}
