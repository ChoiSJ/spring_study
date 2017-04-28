package kr.co.jhta.service.user;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.stu.Enroll;

@Transactional
public interface EnrollService {
	
	List<Enroll> getAllEnrollService();
	Enroll getEnrollByENoService(int no);
	void addRegisubService(Enroll enroll);
	void updatePlusNowNumService(int enrollNo);
	void updateMinusNowNumService(int enrollNo);
	Enroll getEnrollCheckNumService(int enrollNo);
	List<Enroll> getAllEnrollByTcodeService(String siteCode);
	void addEnroll(Enroll enroll);
	List<Enroll> getProfEnroll(String id);
	void updateEnroll(Enroll enroll);
	void deleteEnroll(int no);
	List<Enroll> enrollAllList(int no);
}