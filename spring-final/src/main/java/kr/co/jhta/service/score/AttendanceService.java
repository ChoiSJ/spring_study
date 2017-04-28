package kr.co.jhta.service.score;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.Attendance;
import kr.co.jhta.vo.Scorelist;
@Transactional
@Service
public interface AttendanceService {
	List<Attendance> getAllAttendanceList();
	Attendance getAttendanceListByScoreNo(int sno);
	void addAttendance();
	void delAttendance(int sno);
	List<Scorelist> getAttInfolistByStuNo(int stuno);
	void updateAttendanceByAttno(Attendance week);
	void updateAttScoreByScoreNo(Attendance week);
}
