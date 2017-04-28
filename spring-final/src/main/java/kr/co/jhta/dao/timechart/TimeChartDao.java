package kr.co.jhta.dao.timechart;

import java.util.List;

import kr.co.jhta.vo.TimeChart;

public interface TimeChartDao {

	List<TimeChart> getEnroll(int no);

	List<TimeChart> getProfEnroll(String profId);


}