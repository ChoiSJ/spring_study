package kr.co.jhta.service.professor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.professor.ProfessorDao;
import kr.co.jhta.vo.LoginForm;
import kr.co.jhta.vo.Professor;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorDao professordao;
	
	@Override
	public List<Professor> proAllList() {
		return professordao.proAllList();
	}
	@Override
	public Professor loginByProfessor(LoginForm loginForm) {

		Professor prof = professordao.getProfessorById(loginForm.getUserId());
		System.out.println(prof);
		if(prof == null){
			return null;
		}
		if(!loginForm.getUserPwd().equals(prof.getPwd())){
			return null;
		}		
		return prof;
	}	
	
	@Override
	public List<Professor> getProListByTCode(String code) {
		
		return professordao.getProListByTCode(code);
	}
	
	@Override
	public Professor getProfessorById(String id) {
		return professordao.getProfessorById(id);
	}
	@Override
	public void updateProfessorInfo(Professor professor) {
		professordao.updateProfessorInfo(professor);
		
	}
	@Override
	public void updateProfessorPwd(Professor professor) {
		professordao.updateProfessorPwd(professor);
		
	}
}
