package kr.co.jhta.dao.hakjuk;

import java.util.List;

import kr.co.jhta.vo.hakjuk.StudentSearchForm;
import kr.co.jhta.vo.stu.Student;

public interface HakjukDAO {
	
	List<Student> getStudentListBySearchStud(StudentSearchForm ssf);
	List<Student> getAllStudent();
	Student getStudentById(String id);
	List<Student> getAllAdmissionStud();
	

}
