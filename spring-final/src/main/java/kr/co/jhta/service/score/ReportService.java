package kr.co.jhta.service.score;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.Report;

@Transactional
@Service
public interface ReportService {
	void addReport();
	void delReport(int sno);
	Report getReportByScoreNo(int sno);
}
