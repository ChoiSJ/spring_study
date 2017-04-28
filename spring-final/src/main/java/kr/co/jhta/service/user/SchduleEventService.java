package kr.co.jhta.service.user;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.ScheduleEvent;

@Transactional
public interface SchduleEventService {

	ScheduleEvent addNewSchEventService(ScheduleEvent schedule);
	ScheduleEvent getSchEventBySchNoService(int schNo);
	List<ScheduleEvent> getSchEventByDateService(int studNo, Date start, Date end);
	void updateSchEventService(ScheduleEvent scheduleEvent);
	void updateCompletedTrueService(ScheduleEvent schedule);
	void updateCompletedFalseService(ScheduleEvent schedule);
	void deleteSchEvent(Integer studNo, Integer schNo);
	List<ScheduleEvent> getTodaySchEventService(int stuNo);
}
