package kr.co.jhta.service.appli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.dao.appli.ReinstatementDao;
import kr.co.jhta.vo.appli.Leave;

@Transactional
@Service
public class ReinstatementServiceImpl implements ReinstatementService{

	@Autowired
	ReinstatementDao reinDao;
	
	@Override
	public void addNewReinByLeave(Leave leave) {
		reinDao.addNewReinByLeave(leave);
	}
	
	
}
