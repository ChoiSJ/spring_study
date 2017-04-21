package kr.co.jhta.service.appli;

import java.util.List;

import kr.co.jhta.vo.appli.Leave;

public interface LeaveService {

	void addNewLeaveService(Leave leave);
	List<Leave> getAllEnrolledLeaveByStuNoService(int stuNo);
	
	void deleteEnrollByNoService(int lNo, int stuNo);
	String getCnameByCcodeService(String cCode);
	void updateLeaveService(int lNo, int stuNo, String cCode);
}
