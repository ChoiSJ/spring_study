package kr.co.jhta.service.user;

import java.util.List;

import kr.co.jhta.vo.LoginForm;
import kr.co.jhta.vo.stu.Student;

public interface StudentService {
	// login UserCheck
	Student loginByStudent(LoginForm loginForm);
	
	void addNewStudentService();
	List<Student> getAllStudentService();
	Student getStudentById(String id);
	void updateStudentPwdService(Student student);
	void updateStudentInfoService(Student student);
	void updateStudentProfessorService(String profName);
}
