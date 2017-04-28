package kr.co.jhta.controller.supplementLecture;

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

import kr.co.jhta.service.supplementLecture.SupplementLectureService;
import kr.co.jhta.vo.SupplementLectureTableVo;
import kr.co.jhta.vo.SupplementLectureVo;

@Controller
@RequestMapping("/admin")
public class SupplementLectureControllerRest {

	@Autowired
	private SupplementLectureService supplementLectureService;
	
	
	//대학 세분학과 가져오기 
	@GetMapping(path="searchmajor/{collegeCode}")
	public @ResponseBody List<SupplementLectureVo> getMajorList(@PathVariable("collegeCode")String majorCode){
		
		List<SupplementLectureVo> majorList = supplementLectureService.getMajorList(majorCode);
	
		return majorList;
		
	}
	
	//대학 세분화 테이블 조회
	@GetMapping(path="searchSubjectTable/{majorCode}")
	public @ResponseBody List<SupplementLectureTableVo> getMajorTableList(@PathVariable("majorCode")String majorCode){
		
		List<SupplementLectureTableVo> majorTableList = supplementLectureService.getTableList(majorCode);
		
		return majorTableList;
	}
	
	@RequestMapping("/study.do")
	public String study(){
		
		return "supplementarylecture/study";
	}
	
	//휴강 신청 정보 조회
	@GetMapping(path="searchModal/{subjectNo}")
	public @ResponseBody SupplementLectureTableVo getApplicationDetail(@PathVariable("subjectNo")int subjectNo){
		
		System.out.println("과목번호:"+subjectNo);
		
		SupplementLectureTableVo detailInfor = supplementLectureService.getTableModal(subjectNo);
		
		return detailInfor;
	}
	
	//휴강 취소 정보 조회
	@GetMapping(path="searchModalCancle/{subjectNo}")
	public @ResponseBody SupplementLectureTableVo getApplicationDetailCancle(@PathVariable("subjectNo")int subjectNo){
		
		SupplementLectureTableVo detailInforCancle = supplementLectureService.getTableModalCancle(subjectNo);
		
		return detailInforCancle;
	}
	//휴강 신청
	@PostMapping(path="userInformaiton/")
	public @ResponseBody SupplementLectureTableVo addSupplementLectureInformation(@RequestBody SupplementLectureTableVo supplementLecture){
		
		System.out.println("값:"+supplementLecture);
		System.out.println("code:"+supplementLecture.getMajorCode());
		
		//insert
		supplementLectureService.supplementLectureApplication(supplementLecture);
		
		//update
		supplementLectureService.updateSelectLecturecheckedUpdate(supplementLecture.getSubjectNo());
		
		//반환
		return supplementLectureService.getTableModal(supplementLecture.getSubjectNo());
	}
	@DeleteMapping(path="SearchCancle/{subjectNo}")
	public @ResponseBody SupplementLectureTableVo deleteSupplementLectrueInformation(@PathVariable("subjectNo")int subjectNo){
		
		//delete
		supplementLectureService.deleteSupplementLecture(subjectNo);
		
		//update
		supplementLectureService.updateSelectLecturecheckedUpdateCancle(subjectNo);
		
		//반환
		return supplementLectureService.getTableModal(subjectNo);
	}
}
