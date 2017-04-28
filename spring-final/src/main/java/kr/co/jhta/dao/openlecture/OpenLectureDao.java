package kr.co.jhta.dao.openlecture;

import java.util.List;

import kr.co.jhta.vo.InvestGationAttribute;
import kr.co.jhta.vo.LectureEvaluationSheet;
import kr.co.jhta.vo.LectureRatingSave;
import kr.co.jhta.vo.ProfessorOpenLecture;
import kr.co.jhta.vo.ProfessorSubject;

public interface OpenLectureDao {
	
	//전체 조회
	List<ProfessorOpenLecture> getInformationOfProfessorList();
	
	List<ProfessorOpenLecture> getInformationProfessor(String id);
	
	void addInvestgation(InvestGationAttribute item);
	
	//테이블 조회
	List<ProfessorSubject> subjectInquiries(String id);
	
	//테이블 모달 조회
	List<LectureEvaluationSheet> getLecturEevaluationSheet(int subjectNo);
	
	//삭제
	void professorSubjectdelete(int subjectNo);
	
	//강의 조사항목 상세 조회
	List<LectureEvaluationSheet> getInvestListDeatil(int subjectNo);
	
	//강의 평가 여부
	LectureEvaluationSheet getInvestListRegister(int subjectNo);
	
	//강의 평가 점수 등록
	void insertLectureRating(LectureRatingSave lectureRating);
	
	//강의 평가 여부 업데이트
	void updateLectureRatingRegister(LectureRatingSave lectureRatingRegister);
	
	//enroll테이블 업데이트 (강의평가)
	void updateLectureRatingRegisterEnrollTable(int subjectNo);
	
	//openinquiries.do 테이블 전체 조회
	List<ProfessorSubject> subjectRatingInquiriesAll();
}
