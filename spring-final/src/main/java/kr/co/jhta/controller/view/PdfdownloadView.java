package kr.co.jhta.controller.view;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import kr.co.jhta.service.user.*;
import kr.co.jhta.view.*;
import kr.co.jhta.vo.*;

@Controller
@RequestMapping("/stud")
public class PdfdownloadView {
	
	@Autowired 
	private RegisubjectService regiService;
	
	@Autowired
	private PDFBuilder pdfview;
	  
    @RequestMapping(value = "/downloadPDF.do", method = RequestMethod.GET)
    public ModelAndView downloadPdf(@RequestParam(value="subNo") int subNo) throws Exception{
    	ModelAndView mav = new ModelAndView();
    	mav.setView(pdfview);
    	System.out.println(subNo);
    	Syllabus syllabus = regiService.getSyllabusBySubjectNoService(subNo);
    	mav.addObject("syllabus", syllabus);
    	return mav; 
    }
}
