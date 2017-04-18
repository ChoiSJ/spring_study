package kr.co.jhta.service.score;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.score.AttendanceDao;
import kr.co.jhta.vo.Attendance;

@Service
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

	@Override
	public void addAttendance() {
		attendanceDao.addAttendance();
	}

	@Override
	public void delAttendance(int sno) {
		attendanceDao.delAttendance(sno);
	}
}
