package kr.co.jhta.service.major;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.major.SubjectDao;
import kr.co.jhta.vo.Subject;

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	private SubjectDao subjectDao;
	
	@Override
	public void addSubject(Subject subject) {
		subjectDao.addSubject(subject);
	}
	
	@Override
	public List<Subject> getAllList() {
		return subjectDao.getAllList();
	}
}
