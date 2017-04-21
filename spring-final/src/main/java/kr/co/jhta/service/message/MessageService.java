package kr.co.jhta.service.message;

import java.util.List;

import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.stu.Student;

public interface MessageService {
	
	List<Student> getAddressByStuName(String searchWord);
	List<Professor> getAddressByProName(String searchWord);
}
