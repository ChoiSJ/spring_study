package kr.co.jhta.service.timechart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.timechart.TimeChartDao;
import kr.co.jhta.vo.TimeChart;

@Service
public class TimeChartServiceImpl implements TimeChartService{
	
	@Autowired
	private TimeChartDao timeChartDao;

	@Override
	public List<TimeChart> getEnroll(int no) {
		return timeChartDao.getEnroll(no);
	}

	@Override
	public List<TimeChart> getProfEnroll(String profId) {
		return timeChartDao.getProfEnroll(profId);
	}
	
	
}