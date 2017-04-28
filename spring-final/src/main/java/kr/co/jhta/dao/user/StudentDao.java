package kr.co.jhta.dao.user;

import java.util.List;
import java.util.Map;

import kr.co.jhta.vo.stu.Student;

public interface StudentDao {
	
	Student getStudentALLById(String id);
	
	void addNewStudent(Student stud);
	List<Student> getAllStudent();
	Student getStudentById(String id);
	
	void updateStudentPwd(Student student);
	void updateStudentInfo(Student student);
	void updateStudentProfessor(String profName);
	
	String getTnameByTcode(Map<String, Object> map);
	String getCnameByRegister(String register);
	
	void updateAddScore(Map<String, Object> map); 
	void updateMinusScore(Map<String, Object> map);
	
	int getNowScore(int stuNo);
}