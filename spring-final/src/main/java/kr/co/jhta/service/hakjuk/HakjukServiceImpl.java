package kr.co.jhta.service.hakjuk;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.hakjuk.HakjukDAO;
import kr.co.jhta.dao.user.StudentDao;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.hakjuk.Leave;
import kr.co.jhta.vo.hakjuk.LeaveSearchForm;
import kr.co.jhta.vo.hakjuk.ProfessorSearchForm;
import kr.co.jhta.vo.hakjuk.SearchForm;
import kr.co.jhta.vo.hakjuk.StudentSearchForm;
import kr.co.jhta.vo.stu.Student;

@Service
public class HakjukServiceImpl implements HakjukService{
	
	
	@Autowired
	private StudentDao studDao;
	
	@Autowired
	private HakjukDAO hakjukDao;
	
	@Override
	public void admissionsStud(Student stud) { // 입학생 저장
		Random rand = new Random();
		String id = (new Date().getYear()-100)+""+(rand.nextInt(99)+10)+((stud.getName().hashCode()*rand.nextInt(99)+10)+"").substring(1,4);
		System.out.println(id);
		stud.setId(id);
		studDao.addNewStudent(stud);
	}
	
	@Override
	public List<Student> getAllStudentService() { // 전체 학생을 조회
		return hakjukDao.getAllStudent();
	}
	@Override
	public Student getStudentByIdService(String id) { // 한명의 학생 조회
		return hakjukDao.getStudentById(id);
	}
	
	@Override
	public List<Student> searchStudent(StudentSearchForm ssf) { //조건에 맞는 학생 가져오기
		return hakjukDao.getStudentListBySearchStud(ssf);
	}
	@Override
	public List<Student> getAllAdmissionStudService() {
		return hakjukDao.getAllAdmissionStud();
	}
	
	@Override
	public List<Professor> getAllProfessorService() { // 모든 재직 교수 정보 조회
		return hakjukDao.getAllProfessor();
	}
	@Override
	public Professor getProfessorByIdService(String id) { // 아이디를 받아서 교수 한명의 정보 조회
		return hakjukDao.getProfessorById(id);
	}
	@Override
	public List<Professor> searchProfessor(ProfessorSearchForm ssf) {
		return hakjukDao.getProfessorListBySearchProf(ssf);
	}
	@Override
	public List<Student> searchAdmissionStudent(SearchForm ssf) {
		return hakjukDao.getadmissionStudentByForm(ssf);
	}
	@Override
	public List<Leave> getAllLeaveByFalseService() { // 휴학 신청한 전체 목록 조회
		return hakjukDao.getAllLeaveByFalse();
	}
	@Override
	public List<Leave> getAllLeaveByFalseForm(LeaveSearchForm lsf) { //휴학 신청한 학생을 조건에 맞춰서 조회
		return hakjukDao.getAllLeaveFalseByForm(lsf);
	}
	
	@Override
	public List<Leave> getAllLeaveByTrueService() { // 휴학 승인된 전체 목록 조회
		return hakjukDao.getAllLeaveByTrue();
	}
	@Override
	public List<Leave> getAllLeaveByTrueForm(LeaveSearchForm lsf) { // 조건에 맞는 승인된 목록 조회
		return hakjukDao.getAllLeaveByTrueForm(lsf);
	}
	
	
	
}
