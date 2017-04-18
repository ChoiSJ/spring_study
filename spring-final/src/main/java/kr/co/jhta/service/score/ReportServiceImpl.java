package kr.co.jhta.service.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.score.ReportDao;
import kr.co.jhta.vo.Report;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private ReportDao reportDao;
	
	@Override
	public void addReport() {
		reportDao.addReport();
	}

	@Override
	public void delReport(int sno) {
		reportDao.delReport(sno);
	}

	@Override
	public Report getReportByScoreNo(int sno) {
		return reportDao.getReportByScoreNo(sno);
	}
	
	
}
