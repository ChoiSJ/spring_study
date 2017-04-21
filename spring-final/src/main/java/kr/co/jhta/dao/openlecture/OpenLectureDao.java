package kr.co.jhta.dao.openlecture;

import java.util.List;

import kr.co.jhta.vo.InvestGationAttribute;
import kr.co.jhta.vo.LectureEvaluationSheet;
import kr.co.jhta.vo.ProfessorOpenLecture;
import kr.co.jhta.vo.ProfessorSubject;

public interface OpenLectureDao {

	List<ProfessorOpenLecture> getInformationOfProfessorList();
	
	List<ProfessorOpenLecture> getInformationProfessor(String id);
	
	void addInvestgation(InvestGationAttribute item);
	
	//테이블 조회
	List<ProfessorSubject> subjectInquiries(String id);
	
	//테이블 모달 조회
	List<LectureEvaluationSheet> getLecturEevaluationSheet(int subjectNo);
	
	//삭제
	void professorSubjectdelete(int subjectNo);
}
