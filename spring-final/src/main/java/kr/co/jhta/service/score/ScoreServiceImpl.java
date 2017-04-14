package kr.co.jhta.service.score;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.co.jhta.dao.score.ScoreDao;
import kr.co.jhta.vo.Score;
import kr.co.jhta.vo.Semester;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.SubjectRegister;
import kr.co.jhta.vo.stu.Student;

@Service
public class ScoreServiceImpl implements ScoreService{
	
	@Autowired
	private ScoreDao scoreDao;

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

	
}
