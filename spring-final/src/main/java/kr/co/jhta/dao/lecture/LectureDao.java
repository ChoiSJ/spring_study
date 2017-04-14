package kr.co.jhta.dao.lecture;

import java.util.List;
import java.util.Map;

import kr.co.jhta.vo.Semester;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.Subject;

public interface LectureDao {
	
	List<Subject> getMajorList(String code);
	SiteMap getDetpList(String code);
	List<Map<String, Object>> getSubjectList(String code);
	List<Semester> getAllSemesterList();
	Semester getSemesterList(int no);
	List<Map<String, Object>> getAllSubjectList();
}
