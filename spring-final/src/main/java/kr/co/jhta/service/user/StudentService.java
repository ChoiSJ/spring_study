package kr.co.jhta.service.user;

import java.util.List;

import kr.co.jhta.vo.LoginForm;
import kr.co.jhta.vo.stu.Student;

public interface StudentService {
	void addNewStudentService();
	List<Student> getAllStudentService();
	Student loginByStudent(LoginForm loginForm);
	
}
