package kr.co.jhta.dao.report;

import java.util.List;
import java.util.Map;

import kr.co.jhta.vo.Preport;
import kr.co.jhta.vo.PreportContent;

public interface StuReportDao {
	
	void addNewReport(PreportContent stuReport);
	void addNewReportPlusShow(PreportContent stuReport);
	
	PreportContent getStuReportByStuNo(int stuNo);
	List<PreportContent> getStuAllReportByEno(int eno);
	List<Preport> getAllProfReport(int eno);

	Preport getProfReportByPno(int pno);
	PreportContent getStuReportByCno(int cno);
	PreportContent getStuAllReportByEno1(int no);
	void deleteReportByCno(Map<String, Object> map);
	
	void updateStuReport(PreportContent preportContent);
	void updateStuReportNotFile(PreportContent preportContent);
	
	String getAttchFileName(int cno);
	void deleteFilename(int cno);
}