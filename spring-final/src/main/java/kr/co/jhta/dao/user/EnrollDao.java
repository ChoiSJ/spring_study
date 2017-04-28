package kr.co.jhta.dao.user;

import java.util.List;


import kr.co.jhta.vo.stu.Enroll;

public interface EnrollDao {
	List<Enroll> getAllEnroll();
	Enroll getEnrollByENo(int no);
	void addRegisub(Enroll enroll);
	void updatePlusNowNum(int enrollNo);
	void updateMinusNowNum(int enrollNo);
	Enroll getEnrollCheckNum(int enrollNo);
	List<Enroll> getAllEnrollByTcode(String siteCode);
	void addEnroll(Enroll enroll);
	List<Enroll> getEnrollById(String id);
	List<Enroll> getProfEnroll(String id);
	void updateEnroll(Enroll enroll);
	void deleteEnroll(int no);
	List<Enroll> enrollAllList(int no);
}
