package kr.co.jhta.service.hakjuk;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.dao.hakjuk.HakjukDAO;
import kr.co.jhta.dao.user.StudentDao;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.hakjuk.AddProfForm;
import kr.co.jhta.vo.hakjuk.Dropoff;
import kr.co.jhta.vo.hakjuk.Leave;
import kr.co.jhta.vo.hakjuk.LeaveSearchForm;
import kr.co.jhta.vo.hakjuk.ProfessorSearchForm;
import kr.co.jhta.vo.hakjuk.ReinForm;
import kr.co.jhta.vo.hakjuk.Reinstatement;
import kr.co.jhta.vo.hakjuk.SearchForm;
import kr.co.jhta.vo.hakjuk.StudentSearchForm;
import kr.co.jhta.vo.stu.AddStudentForm;
import kr.co.jhta.vo.stu.Student;

@Service
@Transactional
public class HakjukServiceImpl implements HakjukService{
	
	
	@Autowired
	private StudentDao studDao;
	
	@Autowired
	private HakjukDAO hakjukDao;
	
	@Override
	public SiteMap getSiteMapByNameService(String name) {
		return hakjukDao.getSiteMapByName(name);
	}
	
	@Override
	public void updateStudentService(AddStudentForm asf) {
		hakjukDao.updateStudent(asf);
	}
	@Override
	public void updateProfessorService(AddProfForm apf) {
		hakjukDao.updateProfessor(apf);
	}
	
	@Override
	public void admissionsStud(Student stud,String register) { // 입학생 저장
		Random rand = new Random();
		String id = (new Date().getYear()-100)+""+(rand.nextInt(89)+10)+((stud.getName().hashCode()*rand.nextInt(89)+10)+"").substring(1,4);
		stud.setId(id);
		stud.setRegister("AD3000");
		studDao.addNewStudent(stud);
		stud = studDao.getStudentById(id);
		stud.setRegister(register);
		System.out.println(stud);
		hakjukDao.addAdmissions(stud);
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
	public Student getStudentByIdsecondService(String id) {
		return hakjukDao.getStudentByIdsecond(id);
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
	@Override
	public List<kr.co.jhta.vo.appli.Leave> getAllEnrolledLeaveByStuNoService(int no) {
		return hakjukDao.getAllEnrolledLeaveByStuNo(no);
	}
	@Override
	public void updateLeaveByOkService(int no) {
		hakjukDao.updateLeaveByOk(no);
		Leave leave = hakjukDao.getLeaveByNo(no);
		hakjukDao.updateStudentRegister(leave);
	}
	@Override
	public void updateLeaveByCancelService(int no) {
		hakjukDao.updateLeaveByCancel(no);
	}
	
	@Override
	public List<kr.co.jhta.vo.appli.Leave> getLeaveByNoOkService(int no) {
		return hakjukDao.getLeaveByNoOk(no);
	}
	@Override
	public List<Reinstatement> getAllReinFalseService() {
		return hakjukDao.getAllReinFalse();
	}
	@Override
	public Reinstatement getReinByNoService(int no) {
		return hakjukDao.getReinByNo(no);
	}
	@Override
	public kr.co.jhta.vo.appli.Leave getLeaveByNoService(int no) {
		return hakjukDao.getLeaveByNoSecond(no);
	}
	@Override
	public void updateReinByOkService(int no) {
		Reinstatement rein = hakjukDao.getReinByNo(no);
		hakjukDao.updateReinByOk(no);
		Leave leave = new Leave();
		leave.setCode("AD3000");
		leave.setStudent(rein.getStudent());
		hakjukDao.updateStudentRegister(leave);
	}
	
	@Override
	public List<Reinstatement> getAllReinTrueService() {
		return hakjukDao.getAllReinTrue();
	}
	@Override
	public List<Reinstatement> getReinTrueByFormService(ReinForm rf) {
		return hakjukDao.getReinTrueByForm(rf);
	}
	@Override
	public List<Reinstatement> getReinFalseByFormService(ReinForm rf) {
		return hakjukDao.getReinFalseByForm(rf);
	}
	@Override
	public List<Dropoff> getAllDropoffByFalseService() {
		return hakjukDao.getAllDropoffByFalse();
	}
	@Override
	public Dropoff getDropoffByFalseNOService(int no) {
		return hakjukDao.getDropoffByFalseNO(no);
	}
	@Override
	public void updateDropOK(int no) {
		Dropoff drop = hakjukDao.getDropoffByFalseNO(no);
		hakjukDao.updateDropoffokByNo(no);
		Leave leave = new Leave();
		leave.setCode("OU1000");
		leave.setStudent(drop.getStudent());
		hakjukDao.updateStudentRegister(leave);
	}
	@Override
	public void updateDropNOT(int no) {
		Dropoff drop = hakjukDao.getDropoffByFalseNO(no);
		hakjukDao.updateDropoffnotByNo(no);
	}
	@Override
	public List<Dropoff> getAllDropoffByFalseFormService(ReinForm rf) {
		return hakjukDao.getAllDropoffByFalseForm(rf);
	}
	@Override
	public List<Dropoff> getAllDropoffByNotFalseService() {
		return hakjukDao.getAllDropoffByNotFalse();
	}
	@Override
	public List<Dropoff> getAllDropoffByNotFalseFormService(ReinForm rf) {
		return hakjukDao.getAllDropoffByNotFalseForm(rf);
	}
	@Override
	public Dropoff getDropoffByNotFalseNOService(int no) {
		return hakjukDao.getDropoffByNotFalseNO(no);
	}
	@Override
	public void addProfessorService(AddProfForm arf) {
		Random rand = new Random();
		String id = "P"+(new Date().getYear()-100)+""+(rand.nextInt(89)+10)+((arf.getName().hashCode()*rand.nextInt(89)+10)+"").substring(1,4);
		arf.setId(id);
		hakjukDao.addProfessor(arf);
	}
}
