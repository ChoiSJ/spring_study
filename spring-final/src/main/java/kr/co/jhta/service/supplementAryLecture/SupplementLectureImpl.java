package kr.co.jhta.service.supplementAryLecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.suplementAryLecture.SupplementLecturedao;
import kr.co.jhta.vo.SupplementAryLecture;


@Service
public class SupplementLectureImpl implements SupplementLectureService {
	
	@Autowired
	private SupplementLecturedao supplementLecture;
	
	@Override
	public List<SupplementAryLecture> getColleageInfor(String rinkCode) {
		
		return supplementLecture.getColleageInfor(rinkCode);
	}
	
	
}
