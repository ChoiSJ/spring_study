package kr.co.jhta.dao.user;

import java.util.*;

import kr.co.jhta.vo.*;
import kr.co.jhta.vo.stu.Regisubject;

public interface RegisubjectDao {

	List<Regisubject> getAllRegisInfo();
	List<Regisubject> getRegisByUserNo(int userNo);	
	void deleteRegisubByENo(int enrollNo);
	Syllabus getSyllabusBySubjectNo(int subNo);
	Regisubject getRegisByStuNoENo(Map<String, Object> map);
}