package kr.co.jhta.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.jhta.service.user.SchduleEventService;
import kr.co.jhta.vo.ScheduleEvent;
import kr.co.jhta.vo.ScheduleEventForm;
import kr.co.jhta.vo.stu.Student;

@RestController
@RequestMapping("/stud")
public class ScheduleEventController {
		
	@Autowired
	SchduleEventService scheduleService;
	
	@InitBinder
	public void stringToDateBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping("/addevent.do")
	public ScheduleEvent addEvent(ScheduleEventForm eventForm, Student student) {
		ScheduleEvent schedule = new ScheduleEvent();
		schedule.setTitle(eventForm.getTitle());
		schedule.setDescription(eventForm.getDescription());
		schedule.setStart(eventForm.getStart());
		schedule.setEnd(eventForm.getEnd());
		schedule.setStudent(student);

		return scheduleService.addNewSchEventService(schedule);
	}
	
	@RequestMapping("/eventDetail.do")
	public ScheduleEvent getEvent(@RequestParam("schNo") int schNo, Student student) {
		ScheduleEvent schEvent = scheduleService.getSchEventBySchNoService(schNo); 
		return schEvent;
	}
	
	
	@RequestMapping("/events.do")
	public List<ScheduleEvent> getEvents(Date start, Date end, Student student) {	
		return scheduleService.getSchEventByDateService(student.getNo(), start, end);
	}
	
	@RequestMapping("/deleteEvent.do")
	public ScheduleEvent deletEvent(@RequestParam("schNo") Integer schNo, Student student) {
		scheduleService.deleteSchEvent(student.getNo(), schNo);
		return new ScheduleEvent();
	}
	
}
