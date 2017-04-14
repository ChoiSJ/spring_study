package kr.co.jhta.service.score;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.jhta.dao.score.AttendanceDao;
import kr.co.jhta.vo.Attendance;

public class AttendanceServiceImpl implements AttendanceService{
	@Autowired
	private AttendanceDao attendanceDao;
	
	@Override
	public List<Attendance> getAllAttendanceList() {
		return attendanceDao.getAllAttendanceList();
	}

	@Override
	public Attendance getAttendanceListByScoreNo(int sno) {
		return attendanceDao.getAttendanceListByScoreNo(sno);
	}
	
}
