package kr.co.jhta.dao.score;

import java.util.HashMap;
import java.util.List;

import kr.co.jhta.vo.Score;
import kr.co.jhta.vo.Semester;
import kr.co.jhta.vo.SemesterAvg;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.SubjectRegister;
import kr.co.jhta.vo.stu.Regisubject;
import kr.co.jhta.vo.stu.Student;

public interface ScoreDao {
	
	Student getStudentInfoByNo(int stuNo);
	Subject getSubjectInfoByNo(int jNo);
	Semester getSemesterByNo(int no);
	Score getScoreByNo(int no);
	void updateScoreByNo(Score score);
	void addScore(int pno);
	void delScore(int rno);
	Regisubject getRegisInfoByEno(int enrollNo);
	int getScoreNoByRno(int rno);
	SiteMap getSitemapByCode(String code);
	List<Regisubject> getRegisInfoByhash(HashMap<String, Object> list);
	Score getScoreinfoByRno(int rno);
	SubjectRegister getRegiListByStuNo(int stuno);
	
	List<Regisubject> getSearchInfoByCode(HashMap<String, Object> searchcode);
	List<Regisubject> getSearchInfoBySno(int sno);
	List<Regisubject> getAllSearchInfo();
	List<SemesterAvg> getSemesterAvgBySno(int sno);
	SemesterAvg getSemesterAvgTotalBySno(int sno);
	int getScoreCount();
	List<Regisubject> getAllScorelistByProfID (String pid);
	int getProfNoByEno(int eno);
	List<String> getSemeNameByStuNo(int stno);
	List<Subject> getsubjectlistByProfId(int pid);
	List<Regisubject> getSearchScorelistByhash(HashMap<String, Object> searchcode);
}
