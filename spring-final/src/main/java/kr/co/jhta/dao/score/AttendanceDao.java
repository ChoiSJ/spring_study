package kr.co.jhta.dao.score;

import java.util.List;

import kr.co.jhta.vo.Attendance;
import kr.co.jhta.vo.Scorelist;

public interface AttendanceDao {
	List<Attendance> getAllAttendanceList();
	Attendance getAttendanceListByScoreNo(int sno);
	void addAttendance();
	void delAttendance(int sno);
	List<Scorelist> getAttInfolistByStuNo(int stuno);
	void updateAttendanceByAttno(Attendance week);
	void updateAttScoreByScoreNo(Attendance week);
}
