package kr.co.jhta.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.jhta.service.professor.ProfessorService;
import kr.co.jhta.service.sitemap.SitemapService;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.SiteMap;

@Controller
@RequestMapping("/admin")
public class AjaxHakjukController {
	
	@Autowired
	private SitemapService sitemapService;
		
	@Autowired
	private ProfessorService professorService;
	

	@RequestMapping(value = "/searchmajor",  method=RequestMethod.POST) 
	public @ResponseBody HashMap<String, List> searchmajor(String dept){
		SiteMap siteMap = new SiteMap();
		siteMap.setPreCode(dept);
		List<SiteMap> sitemapList = sitemapService.getAllSitemapSecService(siteMap);
		List<Professor> profList = professorService.getProListByTCode(sitemapList.get(0).getCode());
		HashMap<String, List> map = new HashMap<String, List>();
		map.put("sitemapList", sitemapList);
		map.put("profList", profList);
		return map;
	}
	// 학과 선택하면 교수를 불러오는 ajax 검색 기능
	@RequestMapping(value="/searchprof", method=RequestMethod.POST)
	public @ResponseBody List<Professor> searchprof(String code) {
		return professorService.getProListByTCode(code);
	}
}
