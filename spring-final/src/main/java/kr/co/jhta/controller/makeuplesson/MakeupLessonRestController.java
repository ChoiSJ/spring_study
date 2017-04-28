package kr.co.jhta.controller.makeuplesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.jhta.service.makeuplesson.MakeupLessonService;
import kr.co.jhta.vo.MakeupLessonAll;
import kr.co.jhta.vo.SupplementLectureTableVo;
import kr.co.jhta.vo.SupplementLectureVo;

@Controller
@RequestMapping("/admin")
public class MakeupLessonRestController {

	@Autowired
	private MakeupLessonService makeuplessonservice;
	
	//학과 가져오기
	@GetMapping(path="makeuplessoncollege/{collegeCode}")
	public @ResponseBody List<SupplementLectureVo> makeupLessonColleges(@PathVariable("collegeCode") String linkCode){
		
		List<SupplementLectureVo> collegeList = makeuplessonservice.makeupLessonGetCollege(linkCode);
		
		return collegeList;
	}
	
	//학과로 테이블 조회하기
	//"makeupLessonSearchTable/" + majorCode,
	@GetMapping(path="makeupLessonSearchTable/{majorCode}")
	public @ResponseBody List<MakeupLessonAll> makeupLessonTable(@PathVariable("majorCode") String majorCode){
		
		List<MakeupLessonAll> tableList = makeuplessonservice.makeupLessonGetTable(majorCode);
		
		return tableList;
	}
	
	//보강 신청 조회
	@GetMapping(path="makeupLessonRegisterSelect/{subjectNo}")
	public @ResponseBody MakeupLessonAll makeupLessonTableModal(@PathVariable("subjectNo") int subjectNo){
		
		MakeupLessonAll tabledetail = makeuplessonservice.makeupLessonGetTableModal(subjectNo);
		
		return tabledetail;
	}
	
	
	@PostMapping(path="/makeupLessonUser/")
	public @ResponseBody MakeupLessonAll addMakeupLessonRegister(@RequestBody MakeupLessonAll makeuplesson){
	
		makeuplessonservice.insertMakeupLessonRegister(makeuplesson);
		
		return makeuplessonservice.makeupLessonGetTableModal(makeuplesson.getSubjectNo());
	}
	
	@DeleteMapping(path="makeupCancle/{subjectNo}")
	public @ResponseBody MakeupLessonAll deleteMakeupLessonRegister(@PathVariable("subjectNo") int subjectNo){
		
		makeuplessonservice.deleteMakeupLessonCancle(subjectNo);
		
		return makeuplessonservice.makeupLessonGetTableModal(subjectNo);
	}
	
	
}
