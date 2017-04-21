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
import kr.co.jhta.vo.PageNation;
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
				
	@RequestMapping(value="/scorelist.do",method=RequestMethod.GET)
	public String scorelist(SearchForm searchForm, Model model){
		
		List<Regisubject> regilist = scoreService.getAllSearchInfo();
		/*int rows = scoreService.getScoreCount();
		PageNation pageNation = null;
		pageNation = new PageNation(searchForm.getPageNo(), rows);

		searchForm.setBeginIndex(pageNation.getBeginIndex());
		searchForm.setEndIndex(pageNation.getEndIndex());
		
		model.addAttribute("search", searchForm);*/
		model.addAttribute("regilist", regilist);
		
		return "score/scorelist";
	}
	
	@RequestMapping(value="/scoreform.do", method=RequestMethod.GET)
	public String scoreedit(@RequestParam String sno, Model model){
		int no = Integer.parseInt(sno);
		Score score = scoreService.getScoreByNo(no);
		model.addAttribute("score", score);
		model.addAttribute("scoreupdate", new Score());
		return "score/scoreform";
	}
	
	@RequestMapping(value="/scoreform.do", method=RequestMethod.POST)
	public String scoreupdate(@Valid @ModelAttribute("scoreupdate") Score scores, Errors errors){
		if(errors.hasErrors()){
			return "score/scoreform";
		}
		scoreService.updateScoreByNo(scores);
		return "redirect:/scorelist.do";
	}
	
	@RequestMapping(value="/scoreSearch.do", method=RequestMethod.POST)
	public @ResponseBody List<SiteMap> siteListBysiteCode(String score){
		SiteMap sitemap = new SiteMap();
		sitemap.setPreCode(score);
		return sitemapService.getAllSitemapSecService(sitemap);
	}
	
	@RequestMapping(value="/scoreSearchInfo", method=RequestMethod.POST)
	public @ResponseBody List<Regisubject> searchScoreList(@RequestParam(value="code") String code1, @RequestParam(value="codes") String code2, @RequestParam(value="stucode") String stucode){
		
		HashMap<String, Object> searchcode = new HashMap<String, Object>();
		searchcode.put("code1", code1);
		searchcode.put("code2", code2);
		searchcode.put("stucode", stucode);
		List<Regisubject> scorelist = (List<Regisubject>) scoreService.getSearchInfoByCode(searchcode);
		return scorelist;
	}
}
