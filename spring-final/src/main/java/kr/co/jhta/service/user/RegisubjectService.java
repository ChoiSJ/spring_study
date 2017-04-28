package kr.co.jhta.service.user;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.stu.Regisubject;

@Transactional
public interface RegisubjectService {

	List<Regisubject> getAllRegisInfoService();
	List<Regisubject> getRegisByUserNoService(int userNo);
	void deleteRegisubByENoService(int enrollNo);
}