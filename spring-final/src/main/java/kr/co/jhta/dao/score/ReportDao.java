package kr.co.jhta.dao.score;

import kr.co.jhta.vo.Report;

public interface ReportDao {
	void addReport();
	void delReport(int sno);
	Report getReportByScoreNo(int sno);
}
