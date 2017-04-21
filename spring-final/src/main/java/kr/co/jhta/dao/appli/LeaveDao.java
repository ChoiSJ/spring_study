package kr.co.jhta.dao.appli;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.appli.Leave;

@Transactional
public interface LeaveDao {
	
	void addNewLeave(Leave leave);
	List<Leave> getAllEnrolledLeaveByStuNo(int stuNo);
	
	void deleteEnrollByNo(Map<String, Object> map);
	String getCnameByCcode(String cCode);
	void updateLeave(Map<String, Object> map);
}
