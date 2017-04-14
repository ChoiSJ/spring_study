package kr.co.jhta.controller.major;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.jhta.service.major.SemesterService;
import kr.co.jhta.service.sitemap.SitemapService;
import kr.co.jhta.vo.Semester;
import kr.co.jhta.vo.SiteMap;

@Controller
public class SubjectController {

	@Autowired
	private SitemapService sitemapService;
	
	@Autowired
	private SemesterService semesterService;
	
	
	@RequestMapping("/subjectmain")
	public String subjectMain(Model model) {
		return "major/subjectmain";
	}
	
	@RequestMapping(value="/addsubject", method=RequestMethod.GET)
	public String subjectform(Model model) {
		
		List<SiteMap> deptList = sitemapService.getAllSitemapPreService();
		List<Semester> semeList = semesterService.getAllSemester(); 
		if (deptList == null) {
			throw new RuntimeException("Data is not found.");
		}
		
		model.addAttribute("deptList", deptList);
		model.addAttribute("semeList", semeList);
		
		return "major/subjectform";
	}
	
	// 대학을 선택하면 학과들이 검색되도록 하는 ajax 검색 기능
	@RequestMapping(value="/addmajormenu", method=RequestMethod.POST)
	public @ResponseBody List<SiteMap> addSubjectDept(String dept) {
		SiteMap siteMap = new SiteMap();
		siteMap.setPreCode(dept);
		
		return sitemapService.getAllSitemapSecService(siteMap);
	}
	
	// 학과 선택하면 교수를 불러오는 ajax 검색 기능
	@RequestMapping(value="/addsubjectmenu", method=RequestMethod.POST)
	public @ResponseBody List<SiteMap> addProfDept(String dept) {
		SiteMap siteMap = new SiteMap();
		siteMap.setPreCode(dept);
		
		return sitemapService.getAllSitemapSecService(siteMap);
	}
	
	
	@RequestMapping(value="/addsubject")
	public String registersubject(Model model) {
		

		return "redirect:/subjectmain";
	}
	
	
}
