package kr.co.jhta.dao.user;

import java.util.List;

import kr.co.jhta.vo.stu.Regisubject;

public interface RegisubjectDao {

	List<Regisubject> getAllRegisInfo();
	List<Regisubject> getRegisByUserNo(int userNo);	
	void deleteRegisubByENo(int enrollNo);
}
