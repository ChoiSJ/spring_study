package kr.co.jhta.service.professor;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.Syllabus;

@Transactional
public interface SyllabusService {
	void addNewSyll(Syllabus syllabus);
	List<Syllabus> getAllList();
	Syllabus getByNoList(int no);
	void updateSyll(Syllabus syll);
	void deleteSyll(int no);
	List<Syllabus> getByProNoList(String id);
}
