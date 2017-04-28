package kr.co.jhta.dao.professor;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.Syllabus;
import kr.co.jhta.vo.stu.Regisubject;

@Transactional
public interface ProfessorDao {
	List<Professor> proAllList();
	Professor getProfessorById(String id);
	List<Professor> getProListByTCode(String code);
	void updateProfessorInfo(Professor professor);
	void updateProfessorPwd(Professor professor);
	Professor getLoginUserById(String id);
	
}
