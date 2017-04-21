package kr.co.jhta.service.appli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.appli.ChangeMajorDao;

@Service
public class ChangeMajorServiceImpl implements ChangeMajorService{
	
	@Autowired
	ChangeMajorDao changMDao;
	
}
