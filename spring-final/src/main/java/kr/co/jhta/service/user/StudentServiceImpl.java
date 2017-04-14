package kr.co.jhta.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.user.StudentDao;
import kr.co.jhta.vo.LoginForm;
import kr.co.jhta.vo.stu.Student;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentDao studao;
	
	@Override
	public void addNewStudentService() {
		
	}

	@Override
	public List<Student> getAllStudentService() {
		List<Student> stuList = studao.getAllStudent();
		return stuList;
	}

	@Override
	public Student loginByStudent(LoginForm loginForm) {
		Student stud = studao.getStudentById(loginForm.getUserId());
		
		if(stud == null){
			return null;
		}
		if(!loginForm.getUserPwd().equals(stud.getPwd())){
			return null;
		}		
		return stud;
	}
	
}
