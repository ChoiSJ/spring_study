package kr.co.jhta.service.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.co.jhta.dao.report.StuReportDao;

@Controller
public class StuReportServiceImpl implements StuReportService{

	@Autowired
	StuReportDao stuReportDao;
}
