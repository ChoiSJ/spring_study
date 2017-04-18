package kr.co.jhta.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.user.EnrollDao;
import kr.co.jhta.service.score.ScoreService;
import kr.co.jhta.vo.stu.Enroll;

@Service
public class EnrollServiceImpl implements EnrollService{

	@Autowired
	EnrollDao enrollDao;
	
	@Autowired
	ScoreService scoreService;

	@Override
	public List<Enroll> getAllEnrollService() {
		List<Enroll> enrollList = enrollDao.getAllEnroll();
		return enrollList;
	}

	@Override
	public Enroll getEnrollByENoService(int no) {
		Enroll enroll = enrollDao.getEnrollByENo(no);
		return enroll;
	}

	@Override
	public void addRegisubService(Enroll enroll) {
		enrollDao.addRegisub(enroll);
		scoreService.addScore();
	}

	@Override
	public void updatePlusNowNumService(int enrollNo) {
		enrollDao.updatePlusNowNum(enrollNo);
	}

	@Override
	public void updateMinusNowNumService(int enrollNo) {
		enrollDao.updateMinusNowNum(enrollNo);
	}

	@Override
	public Enroll getEnrollCheckNumService(int enrollNo) {
		Enroll enroll = enrollDao.getEnrollCheckNum(enrollNo);
		return enroll;
	}


	@Override
	public List<Enroll> getAllEnrollByTnameService(String siteName) {
		List<Enroll> enrollList = enrollDao.getAllEnrollByTname(siteName);
		return enrollList;
	}		
}