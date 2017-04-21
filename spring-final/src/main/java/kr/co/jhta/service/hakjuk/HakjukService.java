package kr.co.jhta.service.hakjuk;

import java.util.List;

import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.hakjuk.Leave;
import kr.co.jhta.vo.hakjuk.LeaveSearchForm;
import kr.co.jhta.vo.hakjuk.ProfessorSearchForm;
import kr.co.jhta.vo.hakjuk.SearchForm;
import kr.co.jhta.vo.hakjuk.StudentSearchForm;
import kr.co.jhta.vo.stu.Student;

public interface HakjukService {
	
	void admissionsStud(Student stud);
	List<Student> searchStudent(StudentSearchForm ssf);
	List<Student> getAllStudentService();
	Student getStudentByIdService(String id);
	List<Student> getAllAdmissionStudService();
	List<Professor> getAllProfessorService();
	Professor getProfessorByIdService(String id);
	List<Professor> searchProfessor(ProfessorSearchForm ssf);
	List<Student> searchAdmissionStudent(SearchForm ssf);
	
	List<Leave> getAllLeaveByFalseService();
	List<Leave> getAllLeaveByFalseForm(LeaveSearchForm lsf);
	
	List<Leave> getAllLeaveByTrueService();
	List<Leave> getAllLeaveByTrueForm(LeaveSearchForm lsf);
	
	

}
