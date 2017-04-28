package kr.co.jhta.service.makeuplesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.makeupLesson.MakeupLessonDao;
import kr.co.jhta.vo.MakeupLessonAll;
import kr.co.jhta.vo.SupplementLectureVo;

@Service
public class MakeupLessonServiceImpl implements MakeupLessonService {
 
	@Autowired
	private MakeupLessonDao makeuplessondao;
	
	
	
	//보강전체 조회
	@Override
	public List<MakeupLessonAll> getAllSupplementLecture() {
		
		return makeuplessondao.getAllSupplementLecture();
	}
	
	
	//학과조회하기
	@Override
	public List<SupplementLectureVo> makeupLessonGetCollege(String linkCode) {
		
		return makeuplessondao.makeupLessonGetCollege(linkCode);
	}
	
	//학과로 조회한 테이블
	@Override
	public List<MakeupLessonAll> makeupLessonGetTable(String majorCode) {
		
		return makeuplessondao.makeupLessonGetTable(majorCode);
	}
	
	//모달 상세 조회
	@Override
	public MakeupLessonAll makeupLessonGetTableModal(int subjectNo) {
		
		return makeuplessondao.makeupLessonGetTableModal(subjectNo);
	}
	
	//신청등록
	@Override
	public void insertMakeupLessonRegister(MakeupLessonAll makeuplesson) {
		
		makeuplessondao.insertMakeupLessonRegister(makeuplesson);
	}
	
	//신청 삭제
	@Override
	public void deleteMakeupLessonCancle(int subjectNo) {
		
		makeuplessondao.deleteMakeupLessonCancle(subjectNo);
	}
}
