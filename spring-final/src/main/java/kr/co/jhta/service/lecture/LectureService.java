package kr.co.jhta.service.lecture;

import java.util.List;
import java.util.Map;

import kr.co.jhta.vo.Semester;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.Subject;

public interface LectureService {
	
	List<Subject> getMajorList(String majorCode);
	SiteMap getDetpList(String majorCode);
	List<Map<String, Object>> getSubjectList(String majorCode);
	List<Semester> getAllSemesterList();
	Semester getSemesterList(int semesterNo);
	List<Map<String, Object>> getAllSubjectList();
	int getSubjectRowCount(String majorCode);
	List<SiteMap> getAllMajorList();
	List<Map<String, Object>> getStudentList(Map<?, ?> searchForm);
}
