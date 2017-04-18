package kr.co.jhta.service.professor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.syllabus.SyllabusDao;
import kr.co.jhta.vo.Syllabus;

@Service
public class SyllabusServiceImpl implements SyllabusService {
	@Autowired
	private SyllabusDao syllabusDao;
	
	@Override
	public void addNewSyll(Syllabus syllabus) {
		syllabusDao.addNewSyll(syllabus);	
	}
	
	@Override
	public List<Syllabus> getAllList() {
		return syllabusDao.getAllList();
	}
	
	@Override
	public Syllabus getByNoList(int no) {
		return syllabusDao.getByNoList(no);
	}

	@Override
	public void updateSyll(Syllabus syll) {
		syllabusDao.updateSyll(syll);
		
	}

	@Override
	public void deleteSyll(int no) {
		syllabusDao.deleteSyll(no);
		
	}
	@Override
	public List<Syllabus> getByProNoList(String id) {
		return syllabusDao.getByProNoList(id);
	}
	
}
