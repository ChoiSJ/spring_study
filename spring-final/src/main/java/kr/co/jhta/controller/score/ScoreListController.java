package kr.co.jhta.controller.score;

import java.util.HashMap;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.jhta.service.score.ScoreService;
import kr.co.jhta.service.sitemap.SitemapService;
import kr.co.jhta.vo.Score;
import kr.co.jhta.vo.SearchForm;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.stu.Regisubject;


@Controller
public class ScoreListController {
	
	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private SitemapService sitemapService;
				
	@RequestMapping(value="/admin/scorelist.do",method=RequestMethod.GET)
	public String scorelist(Model model){
		
		List<Regisubject> regilist = scoreService.getAllSearchInfo();
		List<SiteMap> sitemaplist = sitemapService.getAllSitemapService();
		
		model.addAttribute("regilist", regilist);
		model.addAttribute("sitemaplist", sitemaplist);
		
		return "score/scorelist";
	}
	
	@RequestMapping(value="/admin/scoreform.do", method=RequestMethod.GET)
	public String scoreedit(@RequestParam int sno, @RequestParam int psco ,Model model){
		Score score = scoreService.getScoreByNo(sno);
		
		model.addAttribute("no", sno);
		model.addAttribute("psco", psco);
		model.addAttribute("score", score);
		model.addAttribute("scoreupdate", new Score());
		return "score/scoreform";
	}
	
	@RequestMapping(value="/admin/scoreform.do", method=RequestMethod.POST)
	public String scoreupdate(@Valid @ModelAttribute("scoreupdate") Score scores, Errors errors){
		if(errors.hasErrors()){
			return "score/scoreform";
		}
		scoreService.updateScoreByNo(scores);
		return "redirect:/admin/scorelist.do";
	}
	
	@RequestMapping(value="/admin/scoreSearch.do", method=RequestMethod.POST)
	public @ResponseBody List<SiteMap> siteListBysiteCode(SearchForm searchForm, String score){
		SiteMap sitemap = new SiteMap();
		sitemap.setPreCode(score);
		searchForm.setKeyword(score);
		return sitemapService.getAllSitemapSecService(sitemap);
	}
	
	@RequestMapping(value="/admin/scoreSearchInfo", method=RequestMethod.POST)
	public @ResponseBody List<Regisubject> searchScoreList(@RequestParam(value="code") String code1, @RequestParam(value="codes") String code2, @RequestParam(value="stucode") String stucode){
		
		HashMap<String, Object> searchcode = new HashMap<String, Object>();
		searchcode.put("code1", code1);
		searchcode.put("code2", code2);
		searchcode.put("stucode", stucode);
		List<Regisubject> scorelist = (List<Regisubject>) scoreService.getSearchInfoByCode(searchcode);
		System.out.println(scorelist);
		return scorelist;
	}
}
