package kr.co.jhta.controller.board;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.jhta.service.board.BoardService;
import kr.co.jhta.service.sitemap.SitemapService;
import kr.co.jhta.vo.Board;
import kr.co.jhta.vo.BoardForm;
import kr.co.jhta.vo.BoardView;
import kr.co.jhta.vo.PageNation;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.SearchForm;
import kr.co.jhta.vo.SiteMap;

@Controller
public class BoardController {
	
	
	static final String DIRECTORY = "C:\\spring_project\\workspace\\spring-final\\src\\main\\webapp\\resources\\images\\board";
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private SitemapService sitemapSerivce;
	
	@RequestMapping(value="/admin/homeboard", method=RequestMethod.GET)
	public String homeboard(SearchForm searchForm, Model model){
		if (searchForm.getSearchBoardType() == null) {
			searchForm.setSearchBoardType("N");
			
		}
		
		if (searchForm.getDisplay() == 0) {
			searchForm.setDisplay(5);
		}
		
		int rows = boardService.searchBoardCount(searchForm);
		PageNation pageNation = null;
		
		if (searchForm.getDisplay() != 0) {
			pageNation = new PageNation(searchForm.getDisplay(), searchForm.getPageNo(), rows);
		}else {
			pageNation = new PageNation(searchForm.getPageNo(), rows);
		}
		
		searchForm.setBeginIndex(pageNation.getBeginIndex());
		searchForm.setEndIndex(pageNation.getEndIndex());
		
		List<Board> boardList = boardService.searchBoard(searchForm);
		
		model.addAttribute("search", searchForm);
		model.addAttribute("pagination", pageNation);
		model.addAttribute("boardList", boardList);
		
		return "/board/homeboard";
	}
	
	@RequestMapping(value="/admin/homeboard", method=RequestMethod.POST)
	public String searchHomeBoard (SearchForm searchForm, Model model){
		
		int rows = boardService.searchBoardCount(searchForm);
		PageNation pageNation = null;
		
		if (searchForm.getDisplay() != 0) {
			pageNation = new PageNation(searchForm.getDisplay(), searchForm.getPageNo(), rows);
		}else {
			pageNation = new PageNation(searchForm.getPageNo(), rows);
		}
		
		searchForm.setBeginIndex(pageNation.getBeginIndex());
		searchForm.setEndIndex(pageNation.getEndIndex());
		List<Board> boardList = boardService.searchBoard(searchForm);
		
		model.addAttribute("search", searchForm);
		model.addAttribute("pagination", pageNation);
		model.addAttribute("boardList", boardList);
		
		return "/board/homeboard";
	}
	
	
	// 게시판 화면
	@RequestMapping(value="/admin/boardform", method=RequestMethod.GET)
	public String boardForm(Model model){
		
		model.addAttribute("boardForm", new BoardForm());
		return "/board/boardform";
	}
	
	// 수정
	@RequestMapping(value="/admin/modified", method=RequestMethod.GET)
	public String modifiedBoard(@RequestParam int bno, Model model){
		
		Board board = boardService.getBoard(bno);
		
		model.addAttribute("boardForm", new BoardForm());
		model.addAttribute("board", board);
		
		return "/board/boardmodified";
	}
	
	
	// 게시글 수정완료
	@RequestMapping(value="/admin/modified", method=RequestMethod.POST)
	public String modifiedBoardAdd(@Valid BoardForm boardForm, HttpSession session, Errors err, @RequestParam int bno, Model model)throws Exception{
		
		if (err.hasErrors()) {
			return "/board/boardmodified";
		}
		Professor professor = (Professor)session.getAttribute("LOGIN_USER");
		
		if (professor == null) {
			return "redirect:/login?err=deny";
		}
		
		MultipartFile upFile = boardForm.getAttachFile();

		Board board = boardService.getBoard(bno);
		
		if (!upFile.isEmpty()) {
			String filename = upFile.getOriginalFilename();
			board.setFileName(filename);
			IOUtils.copy(upFile.getInputStream(), new FileOutputStream(new File(DIRECTORY, filename)));
			boardForm.setFileName(filename);
		}

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("title", boardForm.getTitle());
		map.put("contents", boardForm.getContents());
		map.put("fileName", boardForm.getFileName());
		
		boardService.updateBoard(map);
		
		return "redirect:/admin/detail?bno="+bno;
	}
	
	// 게시판 디테일
	@RequestMapping(value="/admin/detail", method=RequestMethod.GET)
	public String detailBoard(@RequestParam int bno, Model model, HttpSession session){

		Professor professor = (Professor)session.getAttribute("LOGIN_USER");
		
		if (professor == null) {
			return "redirect:/login?err=deny";
		}
		
		// 조회수 중복 증가 ㄴㄴ
		List<BoardView> viewUser = boardService.getBoardViewUser(bno);
		if (!viewUser.isEmpty()) {
			for (BoardView vUser : viewUser) {
				if (!professor.getName().equals(vUser.getUserId())) {
					BoardView view = new BoardView();
					view.setBno(bno);
					view.setUserId(professor.getName());
					boardService.addBoardView(view);
					boardService.updateCount(bno);
				}else {
					Board board = boardService.getBoard(bno);
					model.addAttribute("board", board);
					return "/board/boarddetail";
				}
			}
		}else {
			BoardView view = new BoardView();
			view.setBno(bno);
			view.setUserId(professor.getName());
			boardService.addBoardView(view);
			boardService.updateCount(bno);
		}
		Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);

		return "/board/boarddetail";
	}
	
	
	// 게시글 등록
	@RequestMapping(value="/admin/boardForm", method=RequestMethod.POST)
	public String addBoard(@Valid BoardForm boardForm, Errors errors, HttpSession session)throws Exception{
		
		if (errors.hasErrors()) {
			return "/board/boardform";
		}
		
		Professor professor = (Professor)session.getAttribute("LOGIN_USER");
		
		if (professor == null) {
			return "redirect:/login?err=deny";
		}
		
		if (!"관리자".equals(professor.getName())) {
			return "redirect:/login?err=deny";
		}
		
		MultipartFile upFile = boardForm.getAttachFile();
		
		Board board = new Board();
		
		BeanUtils.copyProperties(boardForm, board);
		
		
		if (!upFile.isEmpty()) {
			String filename = upFile.getOriginalFilename();
			board.setFileName(filename);
			IOUtils.copy(upFile.getInputStream(), new FileOutputStream(new File(DIRECTORY, filename)));
		}
		
		board.setWriter(professor.getName());
		board.setDepartment(professor.getDivision());
		
		boardService.addNoticeBoard(board);
		
		return "redirect:/admin/board";
		
	}
	
	// 수업 목록
	@RequestMapping("/admin/boardmanagement")
	public String boardManagement(Model model){
		model.addAttribute("majorList", sitemapSerivce.getAllSitemapPreService());
		return "/board/boardmanagement";
	}
	
	// 공지사항 수정 화면 
	@RequestMapping(value="/admin/board", method=RequestMethod.GET)
	public String board (SearchForm searchForm, Model model) {
		int rows = boardService.searchBoardCount(searchForm);
		
		searchForm.setSearchBoardType("N");
		
		PageNation pageNation = null;
		
		if (searchForm.getDisplay() != 0) {
			pageNation = new PageNation(searchForm.getDisplay(), searchForm.getPageNo(), rows);
		}else {
			pageNation = new PageNation(searchForm.getPageNo(), rows);
		}
		
		searchForm.setBeginIndex(pageNation.getBeginIndex());
		searchForm.setEndIndex(pageNation.getEndIndex());
		
		List<Board> boardList = boardService.searchBoard(searchForm);
		
		model.addAttribute("search", searchForm);
		model.addAttribute("pagination", pageNation);
		model.addAttribute("boardList", boardList);
		
		return "/board/board";
	}
	
	// 공지사항 검색
	@RequestMapping(value="/admin/board", method=RequestMethod.POST)
	public String search(SearchForm searchForm, Model model){
		searchForm.setSearchBoardType("N");
		
		int rows = boardService.searchBoardCount(searchForm);
		
		PageNation pageNation = null;
		
		if (searchForm.getDisplay() != 0) {
			pageNation = new PageNation(searchForm.getDisplay(), searchForm.getPageNo(), rows);
		}else {
			pageNation = new PageNation(searchForm.getPageNo(), rows);
		}
		
		searchForm.setBeginIndex(pageNation.getBeginIndex());
		searchForm.setEndIndex(pageNation.getEndIndex());
		
		
		List<Board> boardList = boardService.searchBoard(searchForm);
		
		model.addAttribute("search", searchForm);
		model.addAttribute("pagination", pageNation);
		model.addAttribute("boardList", boardList);
		
		return "/board/board";
	}
	
	@RequestMapping(value="/prof/profnoticeboard", method=RequestMethod.GET)
	public String profNoticeBoard(){
		
		return "/profboard/profnoticeboard";
	}
	@RequestMapping(value="/prof/profqnaboard", method=RequestMethod.GET)
	public String profqnaBoard(){
		return "/profboard/profqnaboard";
	}
	@RequestMapping(value="/prof/profdeptboard", method=RequestMethod.GET)
	public String profdeptBoard(HttpSession session, SearchForm searchForm, Model model){
		
		Professor prof = (Professor)session.getAttribute("LOGIN_USER");
		SiteMap sitemap = sitemapSerivce.getSitemapByCodeService(prof.getDivision());
		
		searchForm.setDepartment(sitemap.getName());
		
		System.out.println(searchForm);
		
		int rows = boardService.searchBoardCount(searchForm);
		
		PageNation pageNation = null;
		
		if (searchForm.getDisplay() != 0) {
			pageNation = new PageNation(searchForm.getDisplay(), searchForm.getPageNo(), rows);
		}else {
			pageNation = new PageNation(searchForm.getPageNo(), rows);
		}
		
		searchForm.setBeginIndex(pageNation.getBeginIndex());
		searchForm.setEndIndex(pageNation.getEndIndex());
		
		
		List<Board> boardList = boardService.searchBoard(searchForm);
		
		model.addAttribute("search", searchForm);
		model.addAttribute("pagination", pageNation);
		model.addAttribute("boardList", boardList);
		
		System.out.println(searchForm);
		System.out.println(pageNation);
		System.out.println(boardList);
		
		return "/profboard/profdeptboard";
	}
	@RequestMapping(value="/prof/profboardform", method=RequestMethod.GET)
	public String profDeptBoardForm(Model model){
		
		model.addAttribute("boardForm", new BoardForm());
		
		return "/profboard/profdeptboardform";
	}
	@RequestMapping(value="/prof/profboardform", method=RequestMethod.POST)
	public String addProfDeptBoardForm(@Valid BoardForm boardForm, Errors err, Model model, HttpSession session)throws Exception{
		
		Professor prof = (Professor)session.getAttribute("LOGIN_USER");
		SiteMap sitemap = sitemapSerivce.getSitemapByCodeService(prof.getDivision());
		
		if (err.hasErrors()) {
			return "/board/boardform";
		}
		
		MultipartFile upFile = boardForm.getAttachFile();
		
		Board board = new Board();
		
		BeanUtils.copyProperties(boardForm, board);
		
		if (!upFile.isEmpty()) {
			String filename = upFile.getOriginalFilename();
			board.setFileName(filename);
			IOUtils.copy(upFile.getInputStream(), new FileOutputStream(new File(DIRECTORY, filename)));
		}
		
		board.setDepartment(sitemap.getName());
		board.setWriter(prof.getName());
		
		boardService.addProfBoard(board);
		
		return "redirect:/prof/profdeptboard";
	}
}
