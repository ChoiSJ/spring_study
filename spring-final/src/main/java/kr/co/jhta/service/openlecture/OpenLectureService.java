package kr.co.jhta.service.openlecture;


import java.util.List;

import kr.co.jhta.vo.InvestGationAttribute;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.ProfessorSubject;

public interface OpenLectureService {
	

	List<Professor> getInformationOfProfessorList();
	
	Professor getInformationProfessor(String id);
	
	void addInvestgation(InvestGationAttribute item);

	List<ProfessorSubject> subjectInquiries(String id);
}
