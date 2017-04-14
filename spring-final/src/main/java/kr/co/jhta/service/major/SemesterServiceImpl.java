package kr.co.jhta.service.major;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.major.SemesterDao;
import kr.co.jhta.vo.Semester;

@Service
public class SemesterServiceImpl implements SemesterService{
	
	@Autowired
	private SemesterDao semesterDao;
	
	@Override
	public void addSemester(Semester semester) {
		semesterDao.addSemester(semester);
		
	}
	
	@Override
	public List<Semester> getAllSemester() {
		
		return semesterDao.getAllSemester();
	}
	
	@Override
	public Semester getSemesterByNo(int no) {
		return semesterDao.getSemesterByNo(no);
	}
	
	@Override
	public void editSemesterByNo(Semester semester) {
		semesterDao.editSemesterByNo(semester);
	}
}
