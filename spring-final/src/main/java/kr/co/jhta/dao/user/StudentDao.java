package kr.co.jhta.dao.user;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.stu.Student;

@Transactional
public interface StudentDao {
	void addNewStudent(Student stud);
	List<Student> getAllStudent();
	Student getStudentById(String id);
	
	void updateStudentPwd(Student student);
	void updateStudentInfo(Student student);
	void updateStudentProfessor(String profName);
	
	String getTnameByTcode(String tCode);
}