package kr.co.jhta.service.timechart;

import java.util.List;

import kr.co.jhta.vo.TimeChart;

public interface TimeChartService {

	List<TimeChart> getEnroll(int no);

	List<TimeChart> getProfEnroll(String profId);
	
}