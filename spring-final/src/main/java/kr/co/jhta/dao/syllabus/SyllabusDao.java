package kr.co.jhta.dao.syllabus;

import java.util.List;

import kr.co.jhta.vo.Syllabus;

public interface SyllabusDao {
	void addNewSyll(Syllabus syllabus);
	List<Syllabus> getAllList();
	Syllabus getByNoList(int no);
	void updateSyll(Syllabus syll);
	void deleteSyll(int no);
	List<Syllabus> getByProNoList(String id);
}
