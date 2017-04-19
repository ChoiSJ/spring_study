package kr.co.jhta.service.score;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.score.AttendanceDao;
import kr.co.jhta.dao.score.ReportDao;
import kr.co.jhta.dao.score.ScoreDao;
import kr.co.jhta.vo.Score;
import kr.co.jhta.vo.Semester;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.SubjectRegister;
import kr.co.jhta.vo.stu.Regisubject;
import kr.co.jhta.vo.stu.Student;

@Service
public class ScoreServiceImpl implements ScoreService{
	
	@Autowired
	private ScoreDao scoreDao;
	
	@Autowired
	private AttendanceDao attDao;
	
	@Autowired
	private ReportDao repDao;

	@Override
	public List<SubjectRegister> getAllRegiList() {
		return scoreDao.getAllRegiList();
	}

	@Override
	public List<Score> getAllScoreList() {
		return scoreDao.getAllScoreList();
	}

	@Override
	public SubjectRegister getRegiListByNo(int regiNo) {
		return scoreDao.getRegiListByNo(regiNo);
	}

	@Override
	public Student getStudentInfoByNo(int stuNo) {
		return scoreDao.getStudentInfoByNo(stuNo);
	}

	@Override
	public Subject getSubjectInfoByNo(int jNo) {
		return scoreDao.getSubjectInfoByNo(jNo);
	}

	@Override
	public Semester getSemesterByNo(int no) {
		return scoreDao.getSemesterByNo(no);
	}

	@Override
	public Score getScoreByNo(int no) {
		return scoreDao.getScoreByNo(no);
	}

	@Override
	public void updateScoreByNo(Score score) {
		scoreDao.updateScoreByNo(score);
	}

	@Override
	public void addScore() {
		scoreDao.addScore();
		attDao.addAttendance();
		repDao.addReport();
		
	}
	
	@Override
	public Regisubject getRegisInfoByEno(int enrollNo) {
		return scoreDao.getRegisInfoByEno(enrollNo);
	}

	@Override
	public void delScore(int rno) {
		int sno = scoreDao.getScoreNoByRno(rno);
		attDao.delAttendance(sno);
		repDao.delReport(sno);
		scoreDao.delScore(rno);
	}

	@Override
	public int getScoreNoByRno(int rno) {
		return scoreDao.getScoreNoByRno(rno);
	}

	@Override
	public SiteMap getSitemapByCode(String code) {
		return scoreDao.getSitemapByCode(code);
	}

	@Override
	public List<Regisubject> getRegisInfoByhash(HashMap<String, Object> list) {
		return scoreDao.getRegisInfoByhash(list);
	}

	@Override
	public Score getScoreinfoByRno(int rno) {
		return scoreDao.getScoreinfoByRno(rno);
	}

	@Override
	public SubjectRegister getRegiListByStuNo(int stuno) {
		return scoreDao.getRegiListByStuNo(stuno);
	}

	@Override
	public List<Regisubject> getSearchInfoByCode(HashMap<String, Object> searchcode) {		
		return scoreDao.getSearchInfoByCode(searchcode);
	}

	
}
