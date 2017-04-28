package kr.co.jhta.dao.appli;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.appli.Leave;

@Transactional
public interface ReinstatementDao {
	
	void addNewReinByLeave(Leave leave);
	

}
