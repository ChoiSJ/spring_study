package kr.co.jhta.controller.open;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.service.openlecture.OpenLectureService;
import kr.co.jhta.vo.Professor;

@Controller
public class OpenLecture {

	@Autowired
	private OpenLectureService lectureservice;
	
	@RequestMapping("/open.do")
	public String openLecture(){
		
		return "openlecture/openlecture";
	}
	
	
	@RequestMapping("/openregister.do")
	public String openLectureRegister(Model model){
		
		List<Professor> openlecturelist = lectureservice.getInformationOfProfessorList();
		model.addAttribute("openlecturelist",openlecturelist);
		
		
		return "openlecture/openlectureregister";
	}
	
}
