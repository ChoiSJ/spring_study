package kr.co.jhta.dao.openlecture;

import java.util.List;

import kr.co.jhta.vo.Professor;

public interface OpenLectureDao {

	List<Professor> getInformationOfProfessorList();
	
	Professor getInformationProfessor(String id);
}
