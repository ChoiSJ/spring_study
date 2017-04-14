package kr.co.jhta.dao.user;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.stu.Enroll;
import kr.co.jhta.vo.stu.Student;

@Transactional
public interface StudentDao {
	void addNewStudent();
	List<Student> getAllStudent();
	Student getStudentById(String id);
	void addRegisub(Enroll enroll);
	
}
