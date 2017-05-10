package kr.co.jhta.service.user;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.user.EnrollDao;
import kr.co.jhta.dao.user.RegisubjectDao;
import kr.co.jhta.service.score.ScoreService;
import kr.co.jhta.vo.*;
import kr.co.jhta.vo.stu.Regisubject;

@Service
public class RegisubjectServiceImpl implements RegisubjectService{
	
	@Autowired
	RegisubjectDao regiDao;
	
	@Autowired
	EnrollDao enrollDao;
	
	@Autowired
	ScoreService scoreService;

	@Override
	public List<Regisubject> getAllRegisInfoService() {
		return regiDao.getAllRegisInfo();
	}

	@Override
	public List<Regisubject> getRegisByUserNoService(int userNo) {
		return regiDao.getRegisByUserNo(userNo);
	}

	@Override
	public Syllabus getSyllabusBySubjectNoService(int subNo) {
		return regiDao.getSyllabusBySubjectNo(subNo);
	}
	
	@Override
	public Regisubject getRegisByStuNoENoService(int stuNo, int eNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stuNo", stuNo);
		map.put("eNo", eNo);
		return regiDao.getRegisByStuNoENo(map);
	}

	@Override
	public void deleteRegisubByENoAndStuNoService(int eNo, int stuNo) {
		HashMap<String, Object> enrolls = new HashMap<String, Object>();
		enrolls.put("eNo", eNo);
		enrolls.put("stuNo", stuNo);
		Regisubject regilist = scoreService.getRegisInfoByEnoAndStuNo(enrolls);
		scoreService.delScore(regilist.getNo());
		regiDao.deleteRegisubByENoAndStuNo(enrolls);
	}



	@Override
	public Regisubject getRegisByRegiNoService(int stuNo, int regiNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stuNo", stuNo);
		map.put("regiNo", regiNo);
		return regiDao.getRegisByRegiNo(map);
	}


}
