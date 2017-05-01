package kr.co.jhta.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleEventForm {
	
	private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private int no;
	private String title;
	private String location;
	private String startDate;
	private String startHour;
	private String startMinute;
	private String endDate;
	private String endHour;
	private String endMinute;
	private boolean allDay;
	
	public ScheduleEventForm() {
		super();
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
	
	
	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Date getStart() {
		return stringToDate(startDate, startHour, startMinute);
	}
	
	public Date getEnd() {
		if (!getAllDay()) {
			return stringToDate(endDate, endHour, endMinute);			
		} else {
			return null;
		}
	}
	
	public boolean getAllDay() {
		return allDay;
	}
	
	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}
	
	public void setStartMinute(String startMinute) {
		this.startMinute = startMinute;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}
	
	public void setEndMinute(String endMinute) {
		this.endMinute = endMinute;
	}
	
	private Date stringToDate(String day, String hour, String minute) {
		try {
			String str = day + " " + hour + ":" + minute;
			return df.parse(str);
		} catch (Exception e) {
			throw new RuntimeException("날짜형식 오류");
		}
	}

	@Override
	public String toString() {
		return "ScheduleEventForm [title=" + title + ", location=" + location + ", startDate=" + startDate
				+ ", startHour=" + startHour + ", startMinute=" + startMinute + ", endDate=" + endDate + ", endHour="
				+ endHour + ", endMinute=" + endMinute + ", allDay=" + allDay + "]";
	}
	
}
