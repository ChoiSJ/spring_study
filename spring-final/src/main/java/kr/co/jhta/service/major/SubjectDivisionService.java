package kr.co.jhta.service.major;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.SubjectDivision;

@Transactional
@Service
public interface SubjectDivisionService {

	void addDivision (SubjectDivision division);
}
