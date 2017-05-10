package kr.co.jhta.service.user;

import java.util.*;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.*;
import kr.co.jhta.vo.stu.Regisubject;

@Transactional
public interface RegisubjectService {

	List<Regisubject> getAllRegisInfoService();
	List<Regisubject> getRegisByUserNoService(int userNo);
	void deleteRegisubByENoAndStuNoService(int eNo, int stuNo);
	Syllabus getSyllabusBySubjectNoService(int subNo);
	Regisubject getRegisByStuNoENoService(int stuNo, int eNo);
	Regisubject getRegisByRegiNoService(int stuNo, int regiNo);
}