package kr.co.jhta.service.user;

import java.util.List;

import kr.co.jhta.vo.stu.Regisubject;

public interface RegisubjectService {

	List<Regisubject> getAllRegisInfoService();
	List<Regisubject> getRegisByUserNoService(int userNo);
	void deleteRegisubByENoService(int enrollNo);
}