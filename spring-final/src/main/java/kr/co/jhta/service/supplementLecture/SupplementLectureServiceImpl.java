package kr.co.jhta.service.supplementLecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.supplementLectureDao.SupplementLectureDao;
import kr.co.jhta.vo.SupplementLectureTableVo;
import kr.co.jhta.vo.SupplementLectureVo;

@Service
public class SupplementLectureServiceImpl implements SupplementLectureService {

	@Autowired
	private SupplementLectureDao supplementlecturedao;
	
	
	
	@Override
	public List<SupplementLectureTableVo> TotalTableList() {
	
		return supplementlecturedao.TotalTableList();
	}
	
	//college 조회
	@Override
	public List<SupplementLectureVo> getMajorList(String majorCode) {
		
		
		return supplementlecturedao.getMajorList(majorCode);
	}
	
	//college table 조회
	@Override
	public List<SupplementLectureTableVo> getTableList(String majorCode) {
		
		return supplementlecturedao.getTableList(majorCode);
	}
	
	//휴강 신청 조회
	@Override
	public SupplementLectureTableVo getTableModal(int subjectNo) {
		
		return supplementlecturedao.getTableModal(subjectNo);
	}
	
	//휴강취소 조회
	@Override
	public SupplementLectureTableVo getTableModalCancle(int subjectNo) {
		
		return  supplementlecturedao.getTableModal(subjectNo);
	}
	
	@Override
	public List<SupplementLectureTableVo> supplementLectureApplication(SupplementLectureTableVo supplementLecture) {
		
		supplementlecturedao.supplementLectureApplication(supplementLecture);
		
		return supplementlecturedao.getTableList(supplementLecture.getMajorCode());
	}
	
	@Override
	public void updateSelectLecturecheckedUpdate(int subjectNo) {
		
		supplementlecturedao.updateSelectLecturecheckedUpdate(subjectNo);
		
	}
	
	@Override
	public void deleteSupplementLecture(int subjectNo) {
		
		supplementlecturedao.deleteSupplementLecture(subjectNo);
		
	}
	
	@Override
	public void updateSelectLecturecheckedUpdateCancle(int subjectNo) {
		
		supplementlecturedao.updateSelectLecturecheckedUpdateCancle(subjectNo);
	}
	
}
