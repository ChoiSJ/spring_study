package kr.co.jhta.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.jhta.service.lecture.LectureService;
import kr.co.jhta.service.sitemap.SitemapService;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.Subject;

@RestController
public class BoardAjaxController {
	
	@Autowired
	private SitemapService sitemapSerivce;
	
	@Autowired
	private LectureService lectureService;
	
	@PostMapping(path="/boardmanagement")
	public @ResponseBody Map<String, Object> getDeptByUnibersityCode (@RequestBody String universityCode) {
		
		SiteMap siteMap = new SiteMap();
		siteMap.setPreCode(universityCode.replace("=", ""));
		
		List<SiteMap> siteList = sitemapSerivce.getAllSitemapSecService(siteMap);
		Map<String, Object> mapList = new HashMap<String, Object>();
		String majorCode = "";
		
		for(SiteMap site : siteList){
			
			majorCode = site.getCode();
			List<Subject> lecture = lectureService.getMajorList(majorCode);
			String subjectCode = "";
			
			for (Subject subject : lecture) {
				
				if (majorCode.equals(subject.getSiteCode().getCode())) {
					
					subjectCode = subject.getSiteCode().getCode();
					
					mapList = new HashMap<String, Object>();
					
					mapList.put("siteMapList", siteList);
					mapList.put("lectureList", lectureService.getMajorList(subjectCode));
					
					return mapList;
				}
			}
		}
		
		mapList = new HashMap<String, Object>();
		mapList.put("siteMapList", siteList);
		
		return mapList;
	}
	
	@PostMapping(path="/boardmanagement.json")
	public @ResponseBody List<Subject> getSubjectByDeptCode(@RequestBody String subjectCode){
		
		return lectureService.getMajorList(subjectCode.replace("=", ""));
		
	}
	
}
