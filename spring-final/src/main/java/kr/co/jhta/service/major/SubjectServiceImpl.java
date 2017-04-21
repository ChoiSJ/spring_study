package kr.co.jhta.service.major;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.major.SubjectDao;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.SubjectEditForm;
import kr.co.jhta.vo.SubjectIsPassed;
import kr.co.jhta.vo.SubjectSearchForm;

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
	@Override
	public List<Subject> getByProIdList(String id) {
		return subjectDao.getByProIdList(id);
	}
	@Override
	public List<SubjectIsPassed> getPassAllList() {
		return subjectDao.getPassAllList();
	}
	
	@Override
	public List<Subject> getSubjectByOpt(SubjectSearchForm searchform) {
		return subjectDao.getSubjectByOpt(searchform);
	}
	
	@Override
	public void addSubject2(Subject subject) {
		subjectDao.addSubject2(subject);
		
	}
	
	@Override
	public void deleteSub(int no) {
		subjectDao.deleteSub(no);
		
	}
	@Override
	public Subject getByNoList(int no) {
		return subjectDao.getByNoList(no);
	}
	@Override
	public void subupdate(Subject subject) {
		subjectDao.subupdate(subject);
		
	}
	
	@Override
	public Subject getSubByNo(int sno) {
		return subjectDao.getByNoList(sno);
	}
	
	@Override
	public String getPassCodeByNo(int sno) {
		return subjectDao.getPassCodeByNo(sno);
	}
	
	@Override
	public void editSubjectByNo(SubjectEditForm editform) {
		subjectDao.editSubjectByNo(editform);
	}
	
	@Override
	public List<Subject> getallenroll() {
		return subjectDao.getallenroll();
	}
}
