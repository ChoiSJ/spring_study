package kr.co.jhta.service.openlecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import kr.co.jhta.dao.openlecture.OpenLectureDao;
import kr.co.jhta.vo.InvestGationAttribute;
import kr.co.jhta.vo.InvestgationItems;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.ProfessorSubject;

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
	
	@Override
	public void addInvestgation(InvestGationAttribute item) {
		
		openLecturedao.addInvestgation(item);
	}
	
	@Override
	public List<ProfessorSubject> subjectInquiries(String id) {
		
		return openLecturedao.subjectInquiries(id);
	}
}