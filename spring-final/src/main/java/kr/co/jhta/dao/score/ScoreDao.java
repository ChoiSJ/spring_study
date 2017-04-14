package kr.co.jhta.dao.score;

import java.util.List;

import kr.co.jhta.vo.Score;
import kr.co.jhta.vo.Semester;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.SubjectRegister;
import kr.co.jhta.vo.stu.Student;

public interface ScoreDao {
	
	List<SubjectRegister> getAllRegiList();
	List<Score> getAllScoreList();
	SubjectRegister getRegiListByNo(int regiNo);
	Student getStudentInfoByNo(int stuNo);
	Subject getSubjectInfoByNo(int jNo);
	Semester getSemesterByNo(int no);
	Score getScoreByNo(int no);
	void updateScoreByNo(Score score);
}
