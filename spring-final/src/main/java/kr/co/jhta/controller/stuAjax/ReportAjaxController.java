package kr.co.jhta.controller.stuAjax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.jhta.service.report.StuReportService;

@RestController
@RequestMapping("/stud")
public class ReportAjaxController {

	@Autowired
	StuReportService stuRepService;
	
	@PostMapping(path="/deleteReportFile/{cno}")
	public @ResponseBody Map<String, Object> deleteFilename(@PathVariable("cno") int cno) {
		stuRepService.deleteFilenameService(cno);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Success", "Success");
		return map;

	}
	
}
