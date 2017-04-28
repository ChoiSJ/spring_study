package kr.co.jhta.service.report;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.Preport;

@Transactional
public interface PreportService {
	void addreport(Preport preport);
	List<Preport> getProftitle(int no);
	Preport getByProfNo(int no);
	List<Preport> getProfEnroll(String id);
	Preport getupdatereport(int no);
	void getByNoupdate(Preport preport);
	void deleteReport(int no);
	String getAttchFileName(int no);
	List<Preport> reportAllList();
	Preport getByEnoOne(int eNo, int stuNo);
}
