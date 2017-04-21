package kr.co.jhta.dao.professor;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.Syllabus;

@Transactional
public interface ProfessorDao {
	List<Professor> proAllList();
	Professor getProfessorById(String id);
	List<Professor> getProListByTCode(String code);
	void updateProfessorInfo(Professor professor);
	void updateProfessorPwd(Professor professor);
}
