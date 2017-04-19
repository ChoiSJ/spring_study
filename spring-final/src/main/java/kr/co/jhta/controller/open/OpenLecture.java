package kr.co.jhta.controller.open;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.jhta.service.openlecture.OpenLectureService;
import kr.co.jhta.vo.InvestGationAttribute;
import kr.co.jhta.vo.InvestgationItems;
import kr.co.jhta.vo.OpenSearch;
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
	
	@RequestMapping("/investigating.do")
	public String addInvestingItems(InvestgationItems items){
		
		List<String> itemsList =  items.getContents();
		String id = items.getProfessorId();
		String professorId = items.getProfessorId();
		InvestGationAttribute item = new InvestGationAttribute();
		
		for(int i=0; i<itemsList.size(); i++){
			
			item.setContents(itemsList.get(i));
			item.setProfessorId(professorId);
			lectureservice.addInvestgation(item);
		}
		
		
		return"redirect:/openregister.do";
	}
	
	@RequestMapping("/openinquiries.do")
	public String getOpeninquiries(){
		
		return"openlecture/openinquiries";
	}
	
}
