package kr.co.jhta.service.professor;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.LoginForm;
import kr.co.jhta.vo.Professor;

@Transactional
public interface ProfessorService {
	List<Professor> proAllList();
	Professor loginByProfessor(LoginForm loginForm);
	List<Professor> getProListByTCode(String code);
}
