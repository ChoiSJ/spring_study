package kr.co.jhta.service.openlecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import kr.co.jhta.dao.openlecture.OpenLectureDao;
import kr.co.jhta.vo.Professor;

@Service
public class OpenLectureServiceImpl implements OpenLectureService {
	

	@Autowired
	private OpenLectureDao openLecturedao;
	
	@Override
	public List<Professor> getInformationOfProfessorList() {
		
		return openLecturedao.getInformationOfProfessorList();
	
	}
	
	@Override
	public Professor getInformationProfessor(String id) {
		
		return openLecturedao.getInformationProfessor(id);
	}
}