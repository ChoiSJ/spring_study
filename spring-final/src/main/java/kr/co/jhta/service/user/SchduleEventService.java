package kr.co.jhta.service.user;

import java.util.Date;
import java.util.List;

import kr.co.jhta.vo.ScheduleEvent;

public interface SchduleEventService {

	ScheduleEvent addNewSchEventService(ScheduleEvent schedule);
	ScheduleEvent getSchEventBySchNoService(int schNo);
	List<ScheduleEvent> getSchEventByDateService(int studNo, Date start, Date end);
	void updateSchEventService(ScheduleEvent scheduleEvent);
	void updateIsShowTrueService(ScheduleEvent schedule);
	void updateIsShowFalseService(ScheduleEvent schedule);
}
