package kr.co.jhta.controller.supplementLecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.service.supplementLecture.SupplementLectureService;
import kr.co.jhta.vo.SupplementLectureTableVo;

@Controller
@RequestMapping("/admin")
public class SupplementLectureController {

	@Autowired
	private SupplementLectureService supplementLectureService;
	
	
	@RequestMapping("/supplementmakeuplesson.do")
	public String supplementMakeupLessonView(){
		
		return "supplementarylecture/supplementmakeuplessonmain";
	}
	
	
	
	
	
	//휴강 페이지 띄우기
	@RequestMapping("/supplementLecture.do")
	public String getColleageInformation(Model model){
		
		List<SupplementLectureTableVo> totalData = supplementLectureService.TotalTableList();
		
		model.addAttribute("totalDataList",totalData);
		
		return"supplementarylecture/supplementLecture";
	}
	
	//휴강 재접속
	@RequestMapping("/pageRedirect.do")
	public String resetSupplementLecture(){
		
		return"redirect:/supplementLecture.do";
	}
	
	
}
