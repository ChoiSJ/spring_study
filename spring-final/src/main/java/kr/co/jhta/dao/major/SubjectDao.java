package kr.co.jhta.dao.major;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.SubjectIsPassed;
import kr.co.jhta.vo.SubjectSearchForm;

@Transactional
public interface SubjectDao {

List<Subject> getAllList();
	
	void addSubject (Subject subject);

	List<Subject> getByProIdList(String id);
	
	List<SubjectIsPassed> getPassAllList();
	
	List<Subject> getSubjectByOpt(SubjectSearchForm searchform);
	
	void addSubject2 (Subject subject);
	
	void deleteSub(int no);
	
	Subject getByNoList(int no);
	
	void subupdate(Subject subject);
	
	Subject getSubByNo(int sno);
}
