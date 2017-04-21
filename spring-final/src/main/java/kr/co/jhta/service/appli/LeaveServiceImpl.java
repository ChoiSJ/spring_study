package kr.co.jhta.service.appli;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.appli.LeaveDao;
import kr.co.jhta.vo.appli.Leave;

@Service
public class LeaveServiceImpl implements LeaveService{
	
	@Autowired
	LeaveDao leaveDao;

	@Override
	public void addNewLeaveService(Leave leave) {
		leaveDao.addNewLeave(leave);
	}

	@Override
	public List<Leave> getAllEnrolledLeaveByStuNoService(int stuNo) {
		return leaveDao.getAllEnrolledLeaveByStuNo(stuNo);
	}

	@Override
	public void deleteEnrollByNoService(int lNo, int stuNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lNo", lNo);
		map.put("stuNo", stuNo);
		leaveDao.deleteEnrollByNo(map);		
	}

	@Override
	public String getCnameByCcodeService(String cCode) {
		return leaveDao.getCnameByCcode(cCode);
	}

	@Override
	public void updateLeaveService(int lNo, int stuNo, String cCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lNo", lNo);
		map.put("stuNo", stuNo);
		map.put("cCode", cCode);
		leaveDao.updateLeave(map);
	}

}
