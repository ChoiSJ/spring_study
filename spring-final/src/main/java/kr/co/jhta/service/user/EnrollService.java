package kr.co.jhta.service.user;

import java.util.List;

import kr.co.jhta.vo.stu.Enroll;

public interface EnrollService {
	
	List<Enroll> getAllEnrollService();
	Enroll getEnrollByENoService(int no);
	void addRegisubService(Enroll enroll);
	void updatePlusNowNumService(int enrollNo);
	void updateMinusNowNumService(int enrollNo);
	Enroll getEnrollCheckNumService(int enrollNo);
}
