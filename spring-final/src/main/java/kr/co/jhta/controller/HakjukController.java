package kr.co.jhta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.service.major.SemesterService;
import kr.co.jhta.service.major.SubjectService;
import kr.co.jhta.service.professor.ProfessorService;
import kr.co.jhta.service.sitemap.SitemapService;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.SiteMap;

@Controller
@RequestMapping("/admin")
public class HakjukController {
	
	@Autowired
	private SitemapService sitemapService;
	
	@Autowired
	private SemesterService semesterService;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping("/searchstud")
	public String searchstud(){
		return "collegeregister/searchstud";
	}
	@RequestMapping("/searchprof")
	public String searchprof(){
		return "collegeregister/searchprof";
	}	
	@RequestMapping("/studinfo")
	public String studinfo(@RequestParam("id") String id){
		System.out.println("id = "+id);
		return "collegeregister/studinfo";
	}
	@RequestMapping("/profinfo")
	public String profinfo(@RequestParam("id") String id){
		return "collegeregister/profinfo";
	}	
	@RequestMapping("/leave")
	public String leavesearch(){
		return "collegeregister/leave";
	}
	@RequestMapping("/reinstatement")
	public String reinstatement(){
		return "collegeregister/reinstatement";
	}
	@RequestMapping("/admissions")
	public String admissions(){
		return "collegeregister/admissions";
	}
	@RequestMapping("/admissionstud")
	public String admissionstud(Model model){
		List<SiteMap> sitemapList = sitemapService.getAllSitemapPreService();
		List<SiteMap> subsitemapList = sitemapService.getAllSitemapSecService(sitemapList.get(0));
		List<Professor> profList = professorService.getProListByTCode(sitemapList.get(0).getCode());
		model.addAttribute("sitemapList",sitemapList);
		model.addAttribute("majors",subsitemapList);
		model.addAttribute("professors",profList);
		return "collegeregister/admissionstud";
	}
	@RequestMapping("/disenrollment")
	public String disenrollment(){
		return "collegeregister/disenrollment";
	}
	
	
	
	
}
