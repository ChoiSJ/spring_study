package kr.co.jhta.controller.supplementAryLecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.jhta.service.supplementAryLecture.SupplementLectureService;
import kr.co.jhta.vo.SupplementAryLecture;

@Controller
public class SupplementLectureController {

	@Autowired
	private SupplementLectureService supplementlectureservice;
	
	
	//학과 조회
	@GetMapping(path="/searchcolleage/{rinkCode}")
	private @ResponseBody List<SupplementAryLecture> getColleageInformation(@PathVariable("rinkCode") String rinkCode){
		
		List<SupplementAryLecture> lecture = supplementlectureservice.getColleageInfor(rinkCode);
		
		return lecture;
	}
}
