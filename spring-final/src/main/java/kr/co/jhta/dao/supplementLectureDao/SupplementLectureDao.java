package kr.co.jhta.dao.supplementLectureDao;

import java.util.List;

import kr.co.jhta.vo.SupplementLectureTableVo;
import kr.co.jhta.vo.SupplementLectureVo;

public interface SupplementLectureDao {
	
	//과목 전체 조회
	List<SupplementLectureTableVo>TotalTableList();

	//college 조회
	List<SupplementLectureVo> getMajorList(String majorCode);
	
	//college table 조회
	List<SupplementLectureTableVo>getTableList(String majorCode);
	
	//휴강신청 조회
	SupplementLectureTableVo getTableModal(int subjectNo);
	
	//휴강취소 조회
	SupplementLectureTableVo getTableModalCancle(int subjectNo);
	
	//휴강 신청
	void supplementLectureApplication(SupplementLectureTableVo supplementLecture);
	
	//휴강 신정 확인
	void updateSelectLecturecheckedUpdate(int subjectNo);
	
	//휴강 신청 삭제
	void deleteSupplementLecture(int subjectNo);
	
	//휴강 삭제 업데이트
	void updateSelectLecturecheckedUpdateCancle(int subjectNo);
}
