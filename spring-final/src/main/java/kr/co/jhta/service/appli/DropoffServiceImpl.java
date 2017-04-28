package kr.co.jhta.service.appli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.dao.appli.DropoffDao;
import kr.co.jhta.vo.hakjuk.Dropoff;

@Transactional
@Service
public class DropoffServiceImpl implements DropoffService{
	
	@Autowired
	DropoffDao dropoffDao;
	
	@Override
	public void addNewDropoffService(Dropoff drop) {
		dropoffDao.addNewDropoff(drop);
	}
}
