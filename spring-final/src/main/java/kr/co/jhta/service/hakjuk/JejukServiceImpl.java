package kr.co.jhta.service.hakjuk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.hakjuk.JejukDAO;
import kr.co.jhta.vo.JejukStuSearchForm;
import kr.co.jhta.vo.SubjectSearchForm;
import kr.co.jhta.vo.hakjuk.JejukList;
import kr.co.jhta.vo.hakjuk.StudentJejuk;
import kr.co.jhta.vo.stu.Student;

@Service
public class JejukServiceImpl implements JejukService{

	@Autowired
	private JejukDAO jejukDao;
	
	@Override
	public List<Student> searchByOpt(JejukStuSearchForm searchForm) {
		return jejukDao.searchByOpt(searchForm);
	}
	
	@Override
	public Student getDetailStuForJejuk(int no) {
		return jejukDao.getDetailStuForJejuk(no);
	}
	
	@Override
	public void registjejuk(StudentJejuk jejuk) {
		jejukDao.registjejuk(jejuk);
	}
	
	@Override
	public void studentjejuk(int no) {
		jejukDao.studentjejuk(no);
	}
	
	@Override
	public List<JejukList> getStudentJejuk() {
		return jejukDao.getStudentJejuk();
	}
	
}
