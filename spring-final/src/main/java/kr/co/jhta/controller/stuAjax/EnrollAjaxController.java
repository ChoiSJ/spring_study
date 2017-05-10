package kr.co.jhta.controller.stuAjax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.jhta.service.sitemap.SitemapService;
import kr.co.jhta.vo.SiteMap;

@RestController
@RequestMapping("/stud")
public class EnrollAjaxController {
	
	@Autowired
	private SitemapService sitemapService;

	@PostMapping(path="stuSubjectmenu/{dept}")
	public @ResponseBody List<SiteMap> searchSubject(@PathVariable("dept") String dept) {
		SiteMap siteMap = new SiteMap();
		siteMap.setPreCode(dept);
		return sitemapService.getAllSitemapSecService(siteMap);
	}
}
