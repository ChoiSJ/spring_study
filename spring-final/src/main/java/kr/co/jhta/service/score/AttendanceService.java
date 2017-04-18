package kr.co.jhta.service.score;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.Attendance;
@Transactional
@Service
public interface AttendanceService {
	List<Attendance> getAllAttendanceList();
	Attendance getAttendanceListByScoreNo(int sno);
	void addAttendance();
	void delAttendance(int sno);
}
