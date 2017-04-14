package kr.co.jhta.dao.score;

import java.util.List;

import kr.co.jhta.vo.Attendance;

public interface AttendanceDao {
	List<Attendance> getAllAttendanceList();
	Attendance getAttendanceListByScoreNo(int sno);
}
