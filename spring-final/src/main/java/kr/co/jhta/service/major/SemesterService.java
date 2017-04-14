package kr.co.jhta.service.major;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.Semester;

@Transactional
@Service
public interface SemesterService {

	void addSemester(Semester semester);
	List<Semester> getAllSemester();
	Semester getSemesterByNo(int no);
	void editSemesterByNo(Semester semester);
}
