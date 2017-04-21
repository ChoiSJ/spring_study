package kr.co.jhta.service.appli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.appli.ReinstatementDao;

@Service
public class ReinstatementServiceImpl implements ReinstatementService{

	@Autowired
	ReinstatementDao reinDao;
	
	
}
