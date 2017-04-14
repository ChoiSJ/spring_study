package kr.co.jhta.service.user;

import java.util.List;

import kr.co.jhta.vo.stu.Regisubject;

public interface RegisubjectService {

	List<Regisubject> getAllRegisInfoService();
	Regisubject getRegisByIdService(String id);
	void deleteRegisubByENoService(int enrollNo);
}
