package kr.co.jhta.controller.makeuplesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.service.makeuplesson.MakeupLessonService;
import kr.co.jhta.vo.MakeupLessonAll;

@Controller
@RequestMapping("/admin")
public class MakeupLessonController {

	@Autowired
	private MakeupLessonService makeuplessonservice;
	
	//보강화면으로 가기
	@RequestMapping("/makeuplesson.do")
	public String makeupLessonView(Model model){
		
		List<MakeupLessonAll> supplementLecture = makeuplessonservice.getAllSupplementLecture();
		
		model.addAttribute("supplementLectureList", supplementLecture);
		
		return "/makeuplesson/makeuplesson";
	}
	
	//보강 리셋
	@RequestMapping("/makeuplecturereset.do")
	public String makeupLessonReset(){
		
		return "redirect:/makeuplesson.do";
	}
	
	
	
}
