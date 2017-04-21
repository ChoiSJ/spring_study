package kr.co.jhta.service.openlecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import kr.co.jhta.dao.openlecture.OpenLectureDao;
import kr.co.jhta.vo.InvestGationAttribute;
import kr.co.jhta.vo.LectureEvaluationSheet;
import kr.co.jhta.vo.ProfessorOpenLecture;
import kr.co.jhta.vo.ProfessorSubject;

@Service
public class OpenLectureServiceImpl implements OpenLectureService {
	

	@Autowired
	private OpenLectureDao openLecturedao;
	
	@Override
	public List<ProfessorOpenLecture> getInformationOfProfessorList() {
		
		return openLecturedao.getInformationOfProfessorList();
	
	}
	
	@Override
	public List<ProfessorOpenLecture> getInformationProfessor(String id) {
		
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
	
	@Override
	public List<LectureEvaluationSheet> getLecturEevaluationSheet(int subjectNo) {
		
		return openLecturedao.getLecturEevaluationSheet(subjectNo);
	}
	
	@Override
	public List<ProfessorSubject> professorSubjectdelete(int subjectNo, String id) {
		
		openLecturedao.professorSubjectdelete(subjectNo);
		
		
		return openLecturedao.subjectInquiries(id) ;
	}
}