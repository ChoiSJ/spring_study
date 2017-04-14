package kr.co.jhta.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.user.EnrollDao;
import kr.co.jhta.dao.user.RegisubjectDao;
import kr.co.jhta.vo.stu.Regisubject;

@Service
public class RegisubjectServiceImpl implements RegisubjectService{
	
	@Autowired
	RegisubjectDao regiDao;
	
	@Autowired
	EnrollDao enrollDao;

	@Override
	public List<Regisubject> getAllRegisInfoService() {
		List<Regisubject> regisubList = regiDao.getAllRegisInfo();
		return regisubList;
	}

	@Override
	public Regisubject getRegisByIdService(String id) {
		Regisubject regisub = regiDao.getRegisById(id);
		return regisub;
	}

	@Override
	public void deleteRegisubByENoService(int enrollNo) {
		regiDao.deleteRegisubByENo(enrollNo);		
	}
	
}
