package kr.co.jhta.vo;

import java.util.Date;

import kr.co.jhta.vo.stu.Student;

public class ScheduleEvent {

	private int no;
	private String title;
	private Date start;
	private Date end;
	private String description;
	private String isShow;
	private Student student;
	
	public ScheduleEvent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScheduleEvent(int no, String title, Date start, Date end, String description, String isShow,
			Student student) {
		super();
		this.no = no;
		this.title = title;
		this.start = start;
		this.end = end;
		this.description = description;
		this.isShow = isShow;
		this.student = student;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "ScheduleEvent [no=" + no + ", title=" + title + ", start=" + start + ", end=" + end + ", description="
				+ description + ", isShow=" + isShow + ", student=" + student + "]";
	}	
	
}
