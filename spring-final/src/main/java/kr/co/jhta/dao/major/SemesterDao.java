package kr.co.jhta.dao.major;

import java.util.List;

import kr.co.jhta.vo.Semester;

public interface SemesterDao {

	void addSemester (Semester semester); 
	List<Semester> getAllSemester();
	Semester getSemesterByNo(int no);
	void editSemesterByNo (Semester semester);
}
