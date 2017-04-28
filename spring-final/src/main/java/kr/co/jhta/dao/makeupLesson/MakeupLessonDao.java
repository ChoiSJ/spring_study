package kr.co.jhta.dao.makeupLesson;

import java.util.List;

import kr.co.jhta.vo.MakeupLessonAll;
import kr.co.jhta.vo.SupplementLectureVo;

public interface MakeupLessonDao {

	//보강 전체 조회하기
	List<MakeupLessonAll> getAllSupplementLecture();
	
	//학과 조회하기
	List<SupplementLectureVo> makeupLessonGetCollege(String linkCode);
	
	//학과로 조회한 테이블
	List<MakeupLessonAll>makeupLessonGetTable(String majorCode);
	
	//모달 상세 조회
	MakeupLessonAll makeupLessonGetTableModal(int subjectNo);
	
	//신청등록
	void insertMakeupLessonRegister(MakeupLessonAll makeuplesson);
	
	//신청 삭제
	void deleteMakeupLessonCancle(int subjectNo);
}
