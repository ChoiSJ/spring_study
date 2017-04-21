package kr.co.jhta.service.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.user.StudentDao;
import kr.co.jhta.vo.LoginForm;
import kr.co.jhta.vo.stu.Student;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentDao stuDao;
	
	@Override
	public List<Student> getAllStudentService() {
		List<Student> stuList = stuDao.getAllStudent();
		return stuList;
	}
	

	@Override
	public Student loginByStudent(LoginForm loginForm) {
		Student stud = stuDao.getStudentById(loginForm.getUserId());
		
		if(stud == null){
			return null;
		}
		if(!loginForm.getUserPwd().equals(stud.getPwd())){
			return null;
		}		
		return stud;
	}

	@Override
	public void updateStudentInfoService(Student student) {
		stuDao.updateStudentInfo(student);
	}

	@Override
	public Student getStudentById(String id) {
		Student student = stuDao.getStudentById(id);
		return student;
	}


	@Override
	public void updateStudentPwdService(Student student) {
		stuDao.updateStudentPwd(student);		
	}


	@Override
	public void updateStudentProfessorService(String profName) {
		stuDao.updateStudentProfessor(profName);
	}


	
	


	@Override
	public String getCnameByRegisterService(String register) {
		String cName = stuDao.getCnameByRegister(register);
		return cName;
	}


	@Override
	public String getTnameByTcodeService(int stuNo, String tCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stuNo", stuNo);
		map.put("tCode", tCode);
		String tName = stuDao.getTnameByTcode(map);
		return tName;
	}
	
}