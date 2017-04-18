package kr.co.jhta.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.score.ScoreDao;
import kr.co.jhta.dao.user.EnrollDao;
import kr.co.jhta.dao.user.RegisubjectDao;
import kr.co.jhta.vo.stu.Regisubject;

@Service
public class RegisubjectServiceImpl implements RegisubjectService{
	
	@Autowired
	RegisubjectDao regiDao;
	
	@Autowired
	EnrollDao enrollDao;
	
	@Autowired
	ScoreDao scoreDao;

	@Override
	public List<Regisubject> getAllRegisInfoService() {
		List<Regisubject> regisubList = regiDao.getAllRegisInfo();
		return regisubList;
	}



	@Override
	public void deleteRegisubByENoService(int enrollNo) {
		int rno = scoreDao.getRegisInfoByEno(enrollNo).getNo();
		System.out.println(rno);
		scoreDao.delScore(rno);
		regiDao.deleteRegisubByENo(enrollNo);
	}

	@Override
	public List<Regisubject> getRegisByUserNoService(int userNo) {
		List<Regisubject> regisubList = regiDao.getRegisByUserNo(userNo);
		return regisubList;
	}
	
}
