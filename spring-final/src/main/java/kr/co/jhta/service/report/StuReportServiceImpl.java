package kr.co.jhta.service.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.co.jhta.dao.report.StuReportDao;
import kr.co.jhta.vo.Preport;
import kr.co.jhta.vo.PreportContent;

@Controller
public class StuReportServiceImpl implements StuReportService{

	@Autowired
	StuReportDao stuRepDao;
	
	@Override
	public void addNewReportService(PreportContent stuReport) {
		stuRepDao.addNewReport(stuReport);
	}

	@Override
	public void addNewReportPlusShowService(PreportContent stuReport) {
		stuRepDao.addNewReportPlusShow(stuReport);
	}

	@Override
	public PreportContent getStuReportByStuNoService(int stuNo) {
		return stuRepDao.getStuReportByStuNo(stuNo);
	}

	@Override
	public List<PreportContent> getStuAllReportByEnoService(int eno) {
		return stuRepDao.getStuAllReportByEno(eno);
	}

	@Override
	public List<Preport> getAllProfReportService(int eno) {
		return stuRepDao.getAllProfReport(eno);
	}

	@Override
	public Preport getProfReportByPnoService(int pno) {
		return stuRepDao.getProfReportByPno(pno);
	} 

	@Override
	public PreportContent getStuReportByCnoService(int cno) {
		return stuRepDao.getStuReportByCno(cno);
	}

	@Override
	public void deleteReportByCno(int cno, int stuNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cno", cno);
		map.put("stuNo", stuNo);
		stuRepDao.deleteReportByCno(map);
	}

	@Override
	public void updateStuReportService(PreportContent preportContent) {
		stuRepDao.updateStuReport(preportContent);
	}

	@Override
	public String getAttchFileNameService(int no) {
		PreportContent stuReport =  stuRepDao.getStuReportByCno(no);
		return stuReport.getFilename();
	}
	@Override
	public PreportContent getStuAllReportByEno1(int no) {
		return stuRepDao.getStuAllReportByEno1(no);
	}

	@Override
	public void deleteFilenameService(int cno) {
		stuRepDao.deleteFilename(cno);
	}

	@Override
	public void updateStuReportNotFileService(PreportContent preportContent) {
		stuRepDao.updateStuReportNotFile(preportContent);
	}
	
}
