package kr.co.jhta.service.user;

import java.util.*;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.LoginForm;
import kr.co.jhta.vo.stu.Student;

@Transactional
public interface StudentService {
	// login UserCheck
	Student getStudentALLByIdService(String id);
	
	Student loginByStudent(LoginForm loginForm);
	
	List<Student> getAllStudentService();
	Student getStudentById(String id);
	void updateStudentPwdService(Student student);
	void updateStudentInfoService(Student student);
	void updateStudentProfessorService(String profName);
	
	String getTnameByTcodeService(int stuNo, String tCode);
	String getCnameByRegisterService(String register);
	
	void updateAddScoreService(int score, int stuNo); 
	void updateMinusScoreService(int score, int stuNo);
	
	int getNowScoreService(int stuNo);
	
	String getStuPwdByEmailAndIdService(String stuId, String stuEmail);
	String getStuIdByEmailService(String email);
}
