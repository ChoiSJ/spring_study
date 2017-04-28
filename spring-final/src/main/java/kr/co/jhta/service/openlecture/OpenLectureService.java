package kr.co.jhta.service.openlecture;


import java.util.List;

import kr.co.jhta.vo.InvestGationAttribute;
import kr.co.jhta.vo.LectureEvaluationSheet;
import kr.co.jhta.vo.LectureRatingSave;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.ProfessorOpenLecture;
import kr.co.jhta.vo.ProfessorSubject;

public interface OpenLectureService {
	
	//검색에서 전체 강의 테이블 조회
	List<ProfessorOpenLecture> getInformationOfProfessorList();
	
	List<ProfessorOpenLecture> getInformationProfessor(String id);
	
	void addInvestgation(InvestGationAttribute item);

	List<ProfessorSubject> subjectInquiries(String id);
	
	List<LectureEvaluationSheet> getLecturEevaluationSheet(int subjectNo);
	
	List<ProfessorSubject> professorSubjectdelete(int subjectNo, String id);
	
	//강의평가 조사항목 조회
	List<LectureEvaluationSheet> getInvestListDeatil(int subjectNo);
	
	//강의 평가 점수 등록
	void insertLectureRating(LectureRatingSave lectureRating);
	
	//강의 평가 여부 확인하는 것
	LectureEvaluationSheet getInvestListRegister(int subjectNo);
	
	//강의 평가 여부 업데이트 하는 것
	void updateLectureRatingRegister(LectureRatingSave lectureRatingRegister);
	
	//enroll테이블 업데이트 (강의평가)
	void updateLectureRatingRegisterEnrollTable(int subjectNo);
	
	//openinquiries.do 테이블 전체 조회
	List<ProfessorSubject> subjectRatingInquiriesAll();
}
