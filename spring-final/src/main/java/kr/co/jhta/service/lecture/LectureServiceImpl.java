package kr.co.jhta.service.lecture;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.lecture.LectureDao;
import kr.co.jhta.vo.Semester;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.Subject;

@Service
public class LectureServiceImpl implements LectureService {
	
	@Autowired
	private LectureDao lectureDao;
	
	@Override
	public List<Subject> getMajorList(String majorCode) {
		return lectureDao.getMajorList(majorCode);
	}
	
	@Override
	public SiteMap getDetpList(String majorCode) {
		return lectureDao.getDetpList(majorCode);
	}
	
	@Override
	public List<Map<String, Object>> getSubjectList(String majorCode) {
		return lectureDao.getSubjectList(majorCode);
	}
	
	@Override
	public List<Semester> getAllSemesterList() {
		return lectureDao.getAllSemesterList();
	}
	
	@Override
	public Semester getSemesterList(int semesterNo) {
		return lectureDao.getSemesterList(semesterNo);
	}
	
	@Override
	public List<Map<String, Object>> getAllSubjectList() {
		return lectureDao.getAllSubjectList();
	}
}
