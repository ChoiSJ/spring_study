package kr.co.jhta.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.jhta.service.board.BoardService;
import kr.co.jhta.service.lecture.LectureService;
import kr.co.jhta.service.sitemap.SitemapService;
import kr.co.jhta.vo.Board;
import kr.co.jhta.vo.PageNation;
import kr.co.jhta.vo.SearchForm;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.Subject;

@RestController
public class BoardAjaxController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private SitemapService sitemapSerivce;
	
	@Autowired
	private LectureService lectureService;
	
	@PostMapping(path="/admin/homeboard.json")
	public @ResponseBody List<Board> serachBoardByType(@RequestParam String BoardType,String searchType, String searchKeyword, int Display){
		SearchForm searchForm = new SearchForm();
		
		searchForm.setSearchBoardType(BoardType);
		searchForm.setSearchType(searchType);
		searchForm.setKeyword(searchKeyword);
		searchForm.setDisplay(Display);
		searchForm.setPageNo(1);
		
		System.out.println(searchForm);
		
		int rows = boardService.searchBoardCount(searchForm);
		System.out.println(rows);
		PageNation pageNation = null;
		
		if (searchForm.getDisplay() != 0) {
			pageNation = new PageNation(searchForm.getDisplay(), searchForm.getPageNo(), rows);
		}else {
			pageNation = new PageNation(searchForm.getPageNo(), rows);
		}
		
		searchForm.setBeginIndex(pageNation.getBeginIndex());
		searchForm.setEndIndex(pageNation.getEndIndex());
		
		return boardService.searchBoard(searchForm);
	}
	
	
	//홈피 게시글 관리 삭제
	@RequestMapping(value="/admin/homeboard/delete",method=RequestMethod.POST)
	public Board deleteHomeBoard(@RequestParam int no){
		System.out.println(no);
		Board board = boardService.getBoard(no);
		boardService.deleteView(no);
		boardService.deleteBoardByNo(no);
		return board;
	}
	
	
	// 공지관리 삭제
	@RequestMapping(value="/admin/board/delete",method=RequestMethod.POST)
	public Board deleteBoard(@RequestParam int no){
		Board board = boardService.getBoard(no);
		boardService.deleteView(no);
		boardService.deleteBoardByNo(no);
		return board;
	}
	
	@PostMapping(path="/admin/boardmanagement")
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
	
	@PostMapping(path="/admin/boardmanagement.json")
	public @ResponseBody List<Subject> getSubjectByDeptCode(@RequestBody String subjectCode){
		
		return lectureService.getMajorList(subjectCode.replace("=", ""));
		
	}
	
}
