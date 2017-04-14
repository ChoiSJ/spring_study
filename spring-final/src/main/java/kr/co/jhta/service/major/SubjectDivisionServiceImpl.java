package kr.co.jhta.service.major;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.major.SubjectDivisionDao;
import kr.co.jhta.vo.SubjectDivision;

@Service
public class SubjectDivisionServiceImpl implements SubjectDivisionService{

	@Autowired
	private SubjectDivisionDao subjectDivisionDao;
	
	@Override
	public void addDivision(SubjectDivision division) {
		subjectDivisionDao.addDivision(division);
	}
}
