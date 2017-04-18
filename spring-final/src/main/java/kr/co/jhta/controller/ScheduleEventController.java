package kr.co.jhta.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.jhta.service.user.SchduleEventService;
import kr.co.jhta.vo.ScheduleEvent;
import kr.co.jhta.vo.ScheduleEventForm;
import kr.co.jhta.vo.stu.Student;

@RestController
@RequestMapping("/stud")
public class ScheduleEventController {
	
	private static Logger logger = LoggerFactory.getLogger(ScheduleEventController.class);
	
	@Autowired
	SchduleEventService scheduleService;
	
	@InitBinder
	public void stringToDateBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping("/addevent.do")
	public ScheduleEvent addEvent(ScheduleEventForm eventForm, Student student) {
		logger.info(eventForm.toString());		
		ScheduleEvent schedule = new ScheduleEvent();
		schedule.setTitle(eventForm.getTitle());
		schedule.setDescription(eventForm.getDescription());
		schedule.setStart(eventForm.getStart());
		schedule.setEnd(eventForm.getEnd());
		schedule.setStudent(student);
		logger.info(schedule.toString());

		return scheduleService.addNewSchEventService(schedule);
	}
	
	
	@RequestMapping("/events.do")
	public List<ScheduleEvent> getEvents(Date start, Date end, Student student) {
		logger.info("start: " + start);
		logger.info("end: " + end);
		List<ScheduleEvent> events = scheduleService.getSchEventByDateService(student.getNo(), start, end);
		logger.info(events.toString());
		
		return events;
	}
	
}
