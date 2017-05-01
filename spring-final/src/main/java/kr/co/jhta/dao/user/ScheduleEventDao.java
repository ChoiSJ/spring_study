package kr.co.jhta.dao.user;

import java.util.List;
import java.util.Map;

import kr.co.jhta.vo.ScheduleEvent;

public interface ScheduleEventDao {
	int getSequence();
	void addNewSchEvent(ScheduleEvent schedule);
	ScheduleEvent getSchEventBySchNo(int schNo);
	List<ScheduleEvent> getSchEventByDate(Map<String, Object> map);
	void updateCompletedTrue(ScheduleEvent schedule);
	void updateCompletedFalse(ScheduleEvent schedule);
	void deleteSchEvent(Map<String, Integer> map);
	
	List<ScheduleEvent> getTodaySchEvent(int stuNo);
	void editeSchduleByNo(ScheduleEvent schedule);
}