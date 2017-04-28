package kr.co.jhta.dao.hakjuk;

import java.util.List;

import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.hakjuk.AddProfForm;
import kr.co.jhta.vo.hakjuk.Dropoff;
import kr.co.jhta.vo.hakjuk.Leave;
import kr.co.jhta.vo.hakjuk.LeaveSearchForm;
import kr.co.jhta.vo.hakjuk.ProfessorSearchForm;
import kr.co.jhta.vo.hakjuk.ReinForm;
import kr.co.jhta.vo.hakjuk.Reinstatement;
import kr.co.jhta.vo.hakjuk.SearchForm;
import kr.co.jhta.vo.hakjuk.StudentSearchForm;
import kr.co.jhta.vo.stu.AddStudentForm;
import kr.co.jhta.vo.stu.Student;

public interface HakjukDAO {
	
	SiteMap getSiteMapByName(String name);
	
	void addAdmissions(Student stud);
	void updateStudent(AddStudentForm asf);
	void updateProfessor(AddProfForm apf);
	
	List<Student> getStudentListBySearchStud(StudentSearchForm ssf);
	List<Student> getAllStudent();
	Student getStudentById(String id);
	Student getStudentByIdsecond(String id);
	List<Student> getAllAdmissionStud();
	List<Professor> getAllProfessor();
	Professor getProfessorById(String id);
	List<Professor> getProfessorListBySearchProf(ProfessorSearchForm ssf);
	List<Student> getadmissionStudentByForm(SearchForm ssf);
	
	List<Leave> getAllLeaveByFalse();
	List<Leave> getAllLeaveFalseByForm(LeaveSearchForm lsf);
	
	List<Leave> getAllLeaveByTrue();
	List<Leave> getAllLeaveByTrueForm(LeaveSearchForm lsf);
	List<kr.co.jhta.vo.appli.Leave> getAllEnrolledLeaveByStuNo(int no);
	
	void updateLeaveByOk(int no);
	void updateLeaveByCancel(int no);
	
	Leave getLeaveByNo(int no);
	void updateStudentRegister(Leave leave);
	List<kr.co.jhta.vo.appli.Leave> getLeaveByNoOk(int no);
 	
	List<Reinstatement> getAllReinFalse();
	List<Reinstatement> getAllReinTrue();
	Reinstatement getReinByNo(int no);
	kr.co.jhta.vo.appli.Leave getLeaveByNoSecond(int no);
	
	void updateReinByOk(int no);
	List<Reinstatement> getReinFalseByForm(ReinForm rf);
	List<Reinstatement> getReinTrueByForm(ReinForm rf);
	List<Dropoff> getAllDropoffByFalse();
	Dropoff getDropoffByFalseNO(int no);
	List<Dropoff> getAllDropoffByFalseForm(ReinForm rf);
	
	void updateDropoffokByNo(int no);
	void updateDropoffnotByNo(int no);
	
	List<Dropoff> getAllDropoffByNotFalse();
	Dropoff getDropoffByNotFalseNO(int no);
	List<Dropoff> getAllDropoffByNotFalseForm(ReinForm rf);
	
	void addProfessor(AddProfForm apf);
}
