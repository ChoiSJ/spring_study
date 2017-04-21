package kr.co.jhta.dao.message;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.stu.Student;

@Transactional
public interface MessageDao {
	
	List<Student> getAddressByStuName(String name);
	List<Professor> getAddressByProName(String name);
}
