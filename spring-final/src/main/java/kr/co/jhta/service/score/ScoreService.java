package kr.co.jhta.service.score;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.Score;
import kr.co.jhta.vo.Semester;
import kr.co.jhta.vo.SemesterAvg;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.SubjectRegister;
import kr.co.jhta.vo.stu.Regisubject;
import kr.co.jhta.vo.stu.Student;

@Transactional
@Service
public interface ScoreService {
	List<Regisubject> getRegisInfoByhash(HashMap<String, Object> list);
	
	Student getStudentInfoByNo(int stuNo);
	Subject getSubjectInfoByNo(int jNo);
	
	Semester getSemesterByNo(int no);
	Score getScoreByNo(int no);
	Regisubject getRegisInfoByEno(int enrollNo);
	void updateScoreByNo(Score score);
	SiteMap getSitemapByCode(String code);
	
	void addScore();
	void delScore(int rno);
	int getScoreNoByRno(int rno);
	
	Score getScoreinfoByRno(int rno);
	SubjectRegister getRegiListByStuNo(int stuno);
	List<Regisubject> getSearchInfoByCode(HashMap<String, Object> searchcode);
	List<Regisubject> getSearchInfoBySno(int sno);
	List<SemesterAvg> getSemesterAvgBySno(int sno);
	SemesterAvg getSemesterAvgTotalBySno(int sno);
	List<Regisubject> getAllSearchInfo();
	int getScoreCount();
	
}
