package kr.co.jhta.service.hakjuk;

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

public interface HakjukService {
	
	SiteMap getSiteMapByNameService(String name);

	void admissionsStud(Student stud,String register);
	void updateStudentService(AddStudentForm asf);
	void updateProfessorService(AddProfForm apf);
	List<Student> searchStudent(StudentSearchForm ssf);
	List<Student> getAllStudentService();
	Student getStudentByIdService(String id);
	Student getStudentByIdsecondService(String id);
	List<Student> getAllAdmissionStudService();
	List<Professor> getAllProfessorService();
	Professor getProfessorByIdService(String id);
	List<Professor> searchProfessor(ProfessorSearchForm ssf);
	List<Student> searchAdmissionStudent(SearchForm ssf);
	
	List<Leave> getAllLeaveByFalseService();
	List<Leave> getAllLeaveByFalseForm(LeaveSearchForm lsf);
	
	List<Leave> getAllLeaveByTrueService();
	List<Leave> getAllLeaveByTrueForm(LeaveSearchForm lsf);
	List<kr.co.jhta.vo.appli.Leave> getAllEnrolledLeaveByStuNoService(int no);
	void updateLeaveByOkService(int no);
	void updateLeaveByCancelService(int no);
	
	List<kr.co.jhta.vo.appli.Leave> getLeaveByNoOkService(int no);
	List<Reinstatement> getAllReinFalseService();
	List<Reinstatement> getAllReinTrueService();
	Reinstatement getReinByNoService(int no);
	kr.co.jhta.vo.appli.Leave getLeaveByNoService(int no);
	
	void updateReinByOkService(int no);
	List<Reinstatement> getReinFalseByFormService(ReinForm rf);
	List<Reinstatement> getReinTrueByFormService(ReinForm rf);
	List<Dropoff> getAllDropoffByFalseService();
	Dropoff getDropoffByFalseNOService(int no);
	List<Dropoff> getAllDropoffByFalseFormService(ReinForm rf);
	
	List<Dropoff> getAllDropoffByNotFalseService();
	Dropoff getDropoffByNotFalseNOService(int no);
	List<Dropoff> getAllDropoffByNotFalseFormService(ReinForm rf);
	
	
	void updateDropOK(int no);
	void updateDropNOT(int no);
	
	void addProfessorService(AddProfForm arf);
	
}

