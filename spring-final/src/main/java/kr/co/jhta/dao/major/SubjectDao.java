package kr.co.jhta.dao.major;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.Subject;

@Transactional
public interface SubjectDao {

	void addSubject (Subject subject);
	
	List<Subject> getAllList();
}
