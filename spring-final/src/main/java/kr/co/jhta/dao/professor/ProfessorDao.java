package kr.co.jhta.dao.professor;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.Professor;

@Transactional
public interface ProfessorDao {
	List<Professor> proAllList();
	Professor getProfessorById(String id);
	List<Professor> getProListByTCode(String code);
}
