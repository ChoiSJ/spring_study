package kr.co.jhta.dao.hakjuk;

import java.util.List;

import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.hakjuk.Leave;
import kr.co.jhta.vo.hakjuk.LeaveSearchForm;
import kr.co.jhta.vo.hakjuk.ProfessorSearchForm;
import kr.co.jhta.vo.hakjuk.SearchForm;
import kr.co.jhta.vo.hakjuk.StudentSearchForm;
import kr.co.jhta.vo.stu.Student;

public interface HakjukDAO {
	
	List<Student> getStudentListBySearchStud(StudentSearchForm ssf);
	List<Student> getAllStudent();
	Student getStudentById(String id);
	List<Student> getAllAdmissionStud();
	List<Professor> getAllProfessor();
	Professor getProfessorById(String id);
	List<Professor> getProfessorListBySearchProf(ProfessorSearchForm ssf);
	List<Student> getadmissionStudentByForm(SearchForm ssf);
	
	List<Leave> getAllLeaveByFalse();
	List<Leave> getAllLeaveFalseByForm(LeaveSearchForm lsf);
	
	List<Leave> getAllLeaveByTrue();
	List<Leave> getAllLeaveByTrueForm(LeaveSearchForm lsf);
	
}
