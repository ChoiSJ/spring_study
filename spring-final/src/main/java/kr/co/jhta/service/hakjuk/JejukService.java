package kr.co.jhta.service.hakjuk;

import java.util.List;

import kr.co.jhta.vo.JejukStuSearchForm;
import kr.co.jhta.vo.hakjuk.JejukList;
import kr.co.jhta.vo.hakjuk.StudentJejuk;
import kr.co.jhta.vo.stu.Student;

public interface JejukService {

	List<Student> searchByOpt(JejukStuSearchForm searchForm);
	Student getDetailStuForJejuk(int no);
	void registjejuk(StudentJejuk jejuk);
	void studentjejuk(int no);
	List<JejukList> getStudentJejuk();
}
