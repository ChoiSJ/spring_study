package kr.co.jhta.controller.open;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.service.openlecture.OpenLectureService;
import kr.co.jhta.vo.InvestGationAttribute;
import kr.co.jhta.vo.InvestgationItems;
import kr.co.jhta.vo.LectureEvaluationSheet;
import kr.co.jhta.vo.ProfessorOpenLecture;

@Controller
public class OpenLecture {

	@Autowired
	private OpenLectureService lectureservice;
	
	@RequestMapping("/open.do")
	public String openLecture(){
		
		return "openlecture/openlecture";
	}
	
	
	@RequestMapping("/openratingregister.do")
	public String openLectureRegister(Model model){
	
		List<ProfessorOpenLecture> openlecturelist = lectureservice.getInformationOfProfessorList();
		model.addAttribute("openlecturelist",openlecturelist);
		
		
		return "openlecture/openlectureratingregister";
	}
	
	@RequestMapping("/investigating.do")
	public String addInvestingItems(InvestgationItems items, Errors errors)throws Exception{
		
		if(errors.hasErrors()){
			
			System.out.println(errors.getAllErrors());
			return "redirect:/openregister.do";
			
		}else{
			
			List<String> itemsList =  items.getContents();
			String register = items.getRegister();
			String id = items.getProfessorId();
			int no =items.getSubjectNo();
			String professorId = items.getProfessorId();
			InvestGationAttribute item = new InvestGationAttribute();
			
			for(int i=0; i<itemsList.size(); i++){
				
				item.setRegister(register);
				item.setSubjectNo(no);
				item.setContents(itemsList.get(i));
				item.setProfessorId(professorId);
				
				lectureservice.addInvestgation(item);
			}
			
			return"redirect:/openregister.do";
		}
		
		
	}
	
	@RequestMapping("/openinquiries.do")
	public String getOpeninquiries(){
		
		//LectureEvaluationSheet evaluationSheet = lectureservice.getLecturEevaluationSheet(subjectNo);
		
		return"openlecture/openinquiries";
	}
	
}
