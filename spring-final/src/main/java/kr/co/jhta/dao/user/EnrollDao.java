package kr.co.jhta.dao.user;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.stu.Enroll;
import kr.co.jhta.vo.stu.Regisubject;

@Transactional
public interface EnrollDao {
	List<Enroll> getAllEnroll();
	Enroll getEnrollByENo(int no);
	void addRegisub(Enroll enroll);
	void updatePlusNowNum(int enrollNo);
	void updateMinusNowNum(int enrollNo);
	Enroll getEnrollCheckNum(int enrollNo);
}
