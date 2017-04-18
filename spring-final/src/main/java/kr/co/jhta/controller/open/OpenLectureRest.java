package kr.co.jhta.controller.open;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.jhta.service.openlecture.OpenLectureService;
import kr.co.jhta.vo.Professor;

@RestController
public class OpenLectureRest {	

	@Autowired
	private OpenLectureService openlectureservice;
	
	
	@GetMapping(path="/search/{Search}")
	public @ResponseBody Professor getProfessor(@PathVariable("Search") String id){
		
		Professor professorId = openlectureservice.getInformationProfessor(id);
		
		if (professorId == null) {
			professorId = new Professor();
		}
		
		return professorId;
	}
}

