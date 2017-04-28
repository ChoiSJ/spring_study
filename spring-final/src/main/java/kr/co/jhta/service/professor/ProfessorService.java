package kr.co.jhta.service.professor;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.LoginForm;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.stu.Regisubject;

@Transactional
public interface ProfessorService {
	List<Professor> proAllList();
	Professor loginByProfessor(LoginForm loginForm);
	List<Professor> getProListByTCode(String code);
	Professor getProfessorById(String id);
	void updateProfessorInfo(Professor professor);
	void updateProfessorPwd(Professor professor);
}
