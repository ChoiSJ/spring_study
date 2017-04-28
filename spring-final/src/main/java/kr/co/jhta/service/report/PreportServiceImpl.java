package kr.co.jhta.service.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.co.jhta.dao.report.PreportDao;
import kr.co.jhta.vo.Preport;

@Controller
public class PreportServiceImpl implements PreportService {

	@Autowired
	private PreportDao preportdao;
	
	@Override
	public List<Preport> getProftitle(int no) {
		return preportdao.getProftitle(no);
	}
	@Override
	public Preport getByProfNo(int no) {
		return preportdao.getByProfNo(no);
	}
	@Override
	public List<Preport> getProfEnroll(String id) {
		return preportdao.getProfEnroll(id);
	}
	@Override
	public void addreport(Preport preport) {
		preportdao.addreport(preport);	
	}
	@Override
	public Preport getupdatereport(int no) {
		return preportdao.getupdatereport(no);
	}
	@Override
	public void getByNoupdate(Preport preport) {
		preportdao.getByNoupdate(preport);
	}
	@Override
	public void deleteReport(int no) {
		preportdao.deleteReport(no);
	}
	@Override
	public String getAttchFileName(int no) {
		return preportdao.getAttchFileName(no);
	}
	@Override
	public List<Preport> reportAllList() {
		return preportdao.reportAllList();
	}
	@Override
	public Preport getByEnoOne(int eNo, int stuNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("eNo", eNo);
		map.put("stuNo", stuNo);
		return preportdao.getByEnoOne(map);
	}
	
}
