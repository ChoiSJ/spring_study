package kr.co.jhta.dao.major;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.SubjectEditForm;
import kr.co.jhta.vo.SubjectIsPassed;
import kr.co.jhta.vo.SubjectSearchForm;
import kr.co.jhta.vo.stu.EnrollSearchForm;

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
	
	String getPassCodeByNo(int sno);
	
	void editSubjectByNo (SubjectEditForm editform);
	
	List<Subject> getallenroll();
	
	Subject getByENoList(int no);
	
	Subject getsubByEnrollNo(int eno);
	
	List<Subject> searchEnrollByOption(EnrollSearchForm enrollSerachForm);
	
	List<Subject> getEnrollListByTcode(Map<String, Object> map);
}
