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
		List<Regisubject> regisubList = regiDao.getAllRegisInfo();
		return regisubList;
	}



	@Override
	public void deleteRegisubByENoService(int eNo, int stuNo) {
		HashMap<String, Object> enrolls = new HashMap<String, Object>();
		enrolls.put("eNo", eNo);
		enrolls.put("stuNo", stuNo);
		
		Regisubject regilist = scoreService.getRegisInfoByEnoAndStuNo(enrolls);
		scoreService.delScore(regilist.getNo());
		regiDao.deleteRegisubByENo(eNo);
	}

	@Override
	public List<Regisubject> getRegisByUserNoService(int userNo) {
		List<Regisubject> regisubList = regiDao.getRegisByUserNo(userNo);
		return regisubList;
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
		Regisubject regilist = scoreService.getRegisInfoByEno(eNo);
		scoreService.delScore(regilist.getNo());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("eNo", eNo);
		map.put("stuNo", stuNo);
		regiDao.deleteRegisubByENoAndStuNo(map);
	}



	@Override
	public Regisubject getRegisByRegiNoService(int stuNo, int regiNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stuNo", stuNo);
		map.put("regiNo", regiNo);
		return regiDao.getRegisByRegiNo(map);
	}	

}
