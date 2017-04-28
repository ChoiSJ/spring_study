package kr.co.jhta.controller.board;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import kr.co.jhta.service.board.ReviewService;
import kr.co.jhta.service.sitemap.SitemapService;
import kr.co.jhta.service.user.RegisubjectService;
import kr.co.jhta.vo.Board;
import kr.co.jhta.vo.BoardForm;
import kr.co.jhta.vo.BoardView;
import kr.co.jhta.vo.PageNation;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.Review;
import kr.co.jhta.vo.SearchForm;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.stu.Regisubject;
import kr.co.jhta.vo.stu.Student;

@Controller
public class BoardController {
	
	
	static final String DIRECTORY = "C:\\spring_project\\workspace\\spring-final\\src\\main\\webapp\\resources\\images\\board";
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private SitemapService sitemapSerivce;
	
	@Autowired
	private RegisubjectService regisubjectService;
	
	
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
	public String modifiedBoardAdd(@Valid BoardForm boardForm, Professor professor, Errors err, @RequestParam int bno, Model model)throws Exception{
		
		if (err.hasErrors()) {
			return "/board/boardmodified";
		}
		
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
	
	// 어드민 게시판 디테일
	@RequestMapping(value="/admin/detail", method=RequestMethod.GET)
	public String detailBoard(@RequestParam int bno, Model model, Professor professor){
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
	
	
	// 어드민 게시글 등록
	@RequestMapping(value="/admin/boardForm", method=RequestMethod.POST)
	public String addBoard(@Valid BoardForm boardForm, Errors errors, Professor professor)throws Exception{
		
		if (errors.hasErrors()) {
			return "/board/boardform";
		}
		
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
	
	@RequestMapping(value="/prof/profqnaboard", method=RequestMethod.GET)
	public String profqnaBoard( Model model, Professor professor,SearchForm searchForm){
		int rows = boardService.countProfBoard(professor.getId());
		PageNation pageNation = null;
		
		if (searchForm.getDisplay() != 0) {
			pageNation = new PageNation(searchForm.getDisplay(), searchForm.getPageNo(), rows);
		}else {
			pageNation = new PageNation(searchForm.getPageNo(), rows);
		}
		
		searchForm.setBeginIndex(pageNation.getBeginIndex());
		searchForm.setEndIndex(pageNation.getEndIndex());
		
		List<Board> boardList = boardService.getProfQnaBoard(professor.getId());
		
		model.addAttribute("search", searchForm);
		model.addAttribute("pagination", pageNation);
		model.addAttribute("boardList", boardList);
		
		return "/profboard/profqnaboard";
	}
	@RequestMapping(value="/prof/profqnadetail", method=RequestMethod.GET)
	public String profQnaBoardDetail(@RequestParam int bno, Model model, Professor professor){
		
		List<BoardView> viewUser = boardService.getBoardViewUser(bno);
		List<Review> reviewList = reviewService.getAllReviewByNo(bno);
		
		if (!viewUser.isEmpty()) {
			for (BoardView vUser : viewUser) {
				
				if (!professor.getName().equals(vUser.getUserId())) {
					
					if (vUser.getBno() != bno){
						BoardView view = new BoardView();
						view.setBno(bno);
						view.setUserId(professor.getName());
						boardService.addBoardView(view);
						boardService.updateCount(bno);
					}else {
						Board board = boardService.getBoard(bno);
						model.addAttribute("reviewList", reviewList);
						model.addAttribute("board", board);
						return "profboard/profqnaboarddetail";
					}
				}else {
					Board board = boardService.getBoard(bno);
					model.addAttribute("reviewList", reviewList);
					model.addAttribute("board", board);
					return "profboard/profqnaboarddetail";
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
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("board", board);
		
		return "profboard/profqnaboarddetail";
	}
	
	
	@RequestMapping(value="/prof/profdeptboard", method=RequestMethod.GET)
	public String profdeptBoard(SearchForm searchForm,Professor prof , Model model){
		
		SiteMap sitemap = sitemapSerivce.getSitemapByCodeService(prof.getCode());
		
		searchForm.setDepartment(sitemap.getName());
		int rows = boardService.searchBoardCount(searchForm);
		
		PageNation pageNation = null;
		
		if (searchForm.getDisplay() != 0) {
			pageNation = new PageNation(searchForm.getDisplay(), searchForm.getPageNo(), rows);
		}else {
			pageNation = new PageNation(searchForm.getPageNo(), rows);
		}
		
		searchForm.setBeginIndex(pageNation.getBeginIndex());
		searchForm.setEndIndex(pageNation.getEndIndex());
		searchForm.setSearchBoardType("D");
		
		List<Board> boardList = boardService.searchBoard(searchForm);
		
		model.addAttribute("search", searchForm);
		model.addAttribute("pagination", pageNation);
		model.addAttribute("boardList", boardList);
		
		return "/profboard/profdeptboard";
	}
	
	
	@RequestMapping(value="/prof/profboardform", method=RequestMethod.GET)
	public String profDeptBoardForm(Model model){
		
		model.addAttribute("boardForm", new BoardForm());
		
		return "/profboard/profdeptboardform";
	}
	
	
	@RequestMapping(value="/prof/profboardform", method=RequestMethod.POST)
	public String addProfDeptBoardForm(@Valid BoardForm boardForm, Errors err, Model model, Professor prof)throws Exception{
		
		SiteMap sitemap = sitemapSerivce.getSitemapByCodeService(prof.getDivision());
		
		if (err.hasErrors()) {
			return "/profboard/boardform";
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
		board.setCategory("D");
		boardService.addProfBoard(board);
		
		return "redirect:/prof/profdeptboard";
	}
	
	@RequestMapping(value="/prof/profdetail", method=RequestMethod.GET)
	public String profBoardDetail (@RequestParam int bno, Model model, Professor professor){
		// 조회수 중복 증가 ㄴㄴ
		List<BoardView> viewUser = boardService.getBoardViewUser(bno);
		List<Review> reviewList = reviewService.getAllReviewByNo(bno);
		if (!viewUser.isEmpty()) {
			for (BoardView vUser : viewUser) {
				if (!professor.getName().equals(vUser.getUserId())) {
					
					if (vUser.getBno() != bno){
						BoardView view = new BoardView();
						view.setBno(bno);
						view.setUserId(professor.getName());
						boardService.addBoardView(view);
						boardService.updateCount(bno);
					}else {
						Board board = boardService.getBoard(bno);
						model.addAttribute("reviewList", reviewList);
						model.addAttribute("board", board);
						return "profboard/profqnaboarddetail";
					}
					
					BoardView view = new BoardView();
					view.setBno(bno);
					view.setUserId(professor.getName());
					boardService.addBoardView(view);
					boardService.updateCount(bno);
				}else {
					Board board = boardService.getBoard(bno);
					model.addAttribute("reviewList", reviewList);
					model.addAttribute("board", board);
					return "profboard/profdeptboarddetail";
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
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("board", board);
		
		return "profboard/profdeptboarddetail";
	}
	
	// 교수 문의게시판 리뷰 등록
	@RequestMapping(value="/prof/profqnaaddreview", method=RequestMethod.POST)
	public String addQnaBoardReview (@RequestParam int bno, String reviewContents ,Professor professor) {
		Review review = new Review();
		if (reviewContents == ""){
			return "redirect:/prof/profdetail?bno="+bno+"&err=invalid";
		}
		review.setContents(reviewContents);
		review.setGroupNo(bno);
		review.setWriter(professor.getName());
		reviewService.addReview(review);
		return "redirect:/prof/profdetail?bno="+bno;
	}
	
	@RequestMapping(value="/prof/deleteprofqnaboardreview")
	public String deleteQnaBoardReview(@RequestParam int rno, Professor professor){
		
		Review review = reviewService.getReviewByNo(rno);
		
		if (!professor.getName().equals(review.getWriter())) {
			return "redirect:/prof/profdetail?bno="+review.getGroupNo()+"&err=deny";
		}
		
		return "redirect:/prof/profdetail?bno="+review.getGroupNo();
	}
	
	
	// 교수 학과게시판 리뷰등록
	@RequestMapping(value="/prof/profdeptaddreview", method=RequestMethod.POST)
	public String profDeptAddReview(@RequestParam int bno, String reviewContents, Professor professor){
		Review review = new Review();
		if (reviewContents == null){
			return "redirect:/prof/profdetail?bno="+review.getGroupNo()+"&err=deny";
		}
		review.setContents(reviewContents);
		review.setGroupNo(bno);
		review.setWriter(professor.getName());
		reviewService.addReview(review);
		
		return "redirect:/prof/profdetail?bno="+bno;
	}
	
	// 교수 학과게시판 리뷰 삭제(본인확인)
	@RequestMapping(value="/prof/deleteprofdeptboardreview")
	public String profDeptReviewDelete(@RequestParam int rno, Professor professor){
		
		Review review = reviewService.getReviewByNo(rno);
		
		if (!professor.getName().equals(review.getWriter())) {
		
			return "redirect:/prof/profdetail?bno="+review.getGroupNo()+"&err=deny";
		
		}else {
		
			reviewService.deleteReview(rno);
			
		}
		
		return "redirect:/prof/profdetail?bno="+review.getGroupNo();
		
	};
	
	@RequestMapping(value="/prof/modified", method=RequestMethod.GET)
	public String profBoardModified(@RequestParam int bno, Model model ){
		Board board = boardService.getBoard(bno);
		
		model.addAttribute("boardForm", new BoardForm());
		model.addAttribute("board", board);
		
		return "profboard/profmodified";
	}
	
	@RequestMapping(value="/prof/modified", method=RequestMethod.POST)
	public String profBoardModifiedAdd(@Valid BoardForm boardForm, Professor professor, Errors err, @RequestParam int bno, Model model)throws Exception{
		if (err.hasErrors()) {
			return "/board/boardmodified";
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
		
		return "redirect:/prof/profdetail?bno="+bno;
	}
	
	
	// 학생게시판
	
	// 학생 학과
	// 학과 게시판 보이기
	@RequestMapping(value="/stud/studeptboard", method=RequestMethod.GET)
	public String studeptboard (Student student, SearchForm searchForm, Model model) {
		SiteMap siteMap = sitemapSerivce.getSitemapByCodeService(student.getDivision());
		searchForm.setDepartment(siteMap.getName());
		searchForm.setSearchBoardType("D");
		
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
		
		return "/stuboard/studeptboard";
	}
	
	// 학과게시판 디테일
	@RequestMapping(value="/stud/deptboarddetail", method=RequestMethod.GET)
	public String sutdFreeBoardDetail(@RequestParam int bno,Model model,Student student){
		
		List<BoardView> viewUser = boardService.getBoardViewUser(bno);
		List<Review> reviewList = reviewService.getAllReviewByNo(bno);
		if (!viewUser.isEmpty()) {
			for (BoardView vUser : viewUser) {
				if (!student.getName().equals(vUser.getUserId())) {
					if (vUser.getBno() != bno){
						BoardView view = new BoardView();
						view.setBno(bno);
						view.setUserId(student.getName());
						boardService.addBoardView(view);
						boardService.updateCount(bno);
					}else {
						Board board = boardService.getBoard(bno);
						model.addAttribute("reviewList", reviewList);
						model.addAttribute("board", board);
						return "/stuboard/studdeptboarddetail";
					}

				}else {
					Board board = boardService.getBoard(bno);
					model.addAttribute("board", board);
					model.addAttribute("reviewList", reviewList);
					return "/stuboard/studdeptboarddetail";
				}
			}
		}else {
			BoardView view = new BoardView();
			view.setBno(bno);
			view.setUserId(student.getName());
			boardService.addBoardView(view);
			boardService.updateCount(bno);
		}
		Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		model.addAttribute("reviewList", reviewList);
		return "/stuboard/studdeptboarddetail";
	}
	
	// 학과 게시판 등록
	@RequestMapping(value="/stud/adddeptboard", method=RequestMethod.GET)
	public String studDeptAddBoard(Model model){
		
		model.addAttribute("boardForm", new BoardForm());
		
		return "/stuboard/studdeptaddboardform";
	}
	@RequestMapping(value="/stud/adddeptboard", method=RequestMethod.POST)
	public String studDeptAdd(@Valid BoardForm boardForm, Errors err, Student student){
		if (err.hasErrors()) {
			return "/stuboard/studdeptaddboardform";
		}
		
		Board board = new Board();
		
		BeanUtils.copyProperties(boardForm, board);
		
		board.setWriter(student.getName());
		board.setCategory("D");
		SiteMap siteMap = sitemapSerivce.getSitemapByCodeService(student.getDivision());
		board.setDepartment(siteMap.getName());
		
		boardService.addDeptBoard(board);
		
		return "redirect:/stud/studeptboard";
	}
	
	// 학과 게시판 리뷰 등록
	@RequestMapping(value="/stud/deptboardaddreview", method=RequestMethod.POST)
	public String deptBoardAddReview(@RequestParam int bno,String reviewContents, Student student){
		Review review = new Review();
		if (reviewContents.equals("")){
			return "redirect:/stud/deptboarddetail?bno="+bno+"&err=invalid";
		}
		
		review.setContents(reviewContents);
		review.setGroupNo(bno);
		review.setWriter(student.getName());
		reviewService.addReview(review);
		
		return "redirect:/stud/deptboarddetail?bno="+bno;
		
	}
	// 학과게시판 리뷰 삭제(본인확인)
	@RequestMapping(value="/stud/deletedeptboardreview")
	public String deptBoardReviewDelete(@RequestParam int rno, Student student){
		Review review = reviewService.getReviewByNo(rno);
		
		if (!student.getName().equals(review.getWriter())) {
			return "redirect:/stud/deptboarddetail?bno="+review.getGroupNo()+"&err=deny";
		}else {
			reviewService.deleteReview(rno);
		}
		return "redirect:/stud/deptboarddetail?bno="+review.getGroupNo();
	}
	
	// 학생 자유
	@RequestMapping(value="/stud/stufreeboard", method=RequestMethod.GET)
	public String stufreeboard (SearchForm searchForm,Model model) {
		
		searchForm.setSearchBoardType("F");
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
		
		return "/stuboard/stufreeboard";
	}
	
	// 자유게시판 등록
	@RequestMapping(value="/stud/addfreeboard", method=RequestMethod.GET)
	public String stuFreeBoardForm (Model model) {
		model.addAttribute("boardForm", new BoardForm());
		return "/stuboard/addfreeboard";
	}
	
	// 자유게시판 등록
	@RequestMapping(value="/stud/addfreeboard", method=RequestMethod.POST)
	public String stuFreeAddBoard (@Valid BoardForm boardForm, Errors err, Student student) {
		if (err.hasErrors()) {
			return "/stuboard/addfreeboard";
		}
		Board board = new Board();
		
		BeanUtils.copyProperties(boardForm, board);
		board.setCategory("F");
		board.setWriter(student.getName());
		board.setDepartment(student.getDivision());
		
		boardService.addFreeBoard(board);
		
		return "redirect:/stud/stufreeboard";
	}
	
	// 자유게시판 디테일
	@RequestMapping(value="/stud/studboarddetail",method=RequestMethod.GET)
	public String stuDetailBoard(@RequestParam int bno,Model model, Student student){
		// 조회수 중복 증가 ㄴㄴ
		List<BoardView> viewUser = boardService.getBoardViewUser(bno);
		List<Review> reviewList = reviewService.getAllReviewByNo(bno);
		
		if (!viewUser.isEmpty()) {
			for (BoardView vUser : viewUser) {
				if (!student.getName().equals(vUser.getUserId())) {
					if (vUser.getBno() != bno){
						BoardView view = new BoardView();
						view.setBno(bno);
						view.setUserId(student.getName());
						boardService.addBoardView(view);
						boardService.updateCount(bno);
					}else {
						Board board = boardService.getBoard(bno);
						model.addAttribute("reviewList", reviewList);
						model.addAttribute("board", board);
						return "/stuboard/studfreeboarddetail";
					}
				}else {
					Board board = boardService.getBoard(bno);
					model.addAttribute("board", board);
					model.addAttribute("reviewList", reviewList);
					return "/stuboard/studfreeboarddetail";
				}
			}
		}else {
			BoardView view = new BoardView();
			view.setBno(bno);
			view.setUserId(student.getName());
			boardService.addBoardView(view);
			boardService.updateCount(bno);
		}
		Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		model.addAttribute("reviewList", reviewList);
		
		return "/stuboard/studfreeboarddetail";
	}
	
	// 자유게시판 리뷰
	@RequestMapping(value="/stud/freeboardaddreview",method=RequestMethod.POST)
	public String addFreeBoardReview(@RequestParam int bno, String reviewContents, Student student){
		Review review = new Review();
		if (reviewContents == "") {
			return "redirect:/stud/studboarddetail?bno="+bno+"&err=invalid";
		}
		review.setGroupNo(bno);
		review.setContents(reviewContents);
		review.setWriter(student.getName());
		
		reviewService.addReview(review);
		
		return "redirect:/stud/studboarddetail?bno="+bno;
	}
	
	// 자유게시판 리뷰 삭제(본인확인)
	@RequestMapping(value="/stud/deletefreeboardreview", method=RequestMethod.GET)
	public String deleteFreeBoardReview (@RequestParam int rno, Student student){
			
			Review review = reviewService.getReviewByNo(rno);
			
			if (!student.getName().equals(review.getWriter())) {
				
				return "redirect:/stud/studboarddetail?bno="+review.getGroupNo()+"err=deny";
			}else {
				reviewService.deleteReview(rno);
			}
		
		return "redirect:/stud/studboarddetail?bno="+review.getGroupNo();
	}
	
	// 학생 qna
	@RequestMapping(value="/stud/stuqnaboard", method=RequestMethod.GET)
	public String stuqnaboard (Student student, Model model, SearchForm searchForm) {
		
		List<Regisubject> regiList = regisubjectService.getRegisByUserNoService(student.getNo());
		if (!regiList.isEmpty()) {
			List<Subject> subjectCode = new ArrayList<Subject>();
			
			searchForm.setSearchBoardType("Q");
			
			List<Board> boardList = null;
			PageNation pageNation = null;
			
			for (Regisubject subject : regiList) {
				Subject subjectL = new Subject();
				subjectL.setSubjectName(subject.getSubject().getSubjectName());
				subjectL.setDivision(subject.getSubject().getNo());
				subjectCode.add(subjectL);
			}
			
			searchForm.setSubjectNo(regiList.get(0).getSubject().getNo());
			
			int rows = boardService.searchBoardCount(searchForm);
			
			if (searchForm.getDisplay() != 0) {
				pageNation = new PageNation(searchForm.getDisplay(), searchForm.getPageNo(), rows);
			}else {
				pageNation = new PageNation(searchForm.getPageNo(), rows);
			}
			searchForm.setBeginIndex(pageNation.getBeginIndex());
			searchForm.setEndIndex(pageNation.getEndIndex());
			searchForm.setDisplay(10);
			boardList = boardService.searchBoard(searchForm);
			model.addAttribute("subject", subjectCode);
			model.addAttribute("search", searchForm);
			model.addAttribute("boardList", boardList);
			model.addAttribute("pagination", pageNation);
			return "/stuboard/stuqnaboard";
		} else {
			model.addAttribute("err", "error");
			return "/stuboard/stuqnaboard";
		}
		
	}
	
	@RequestMapping(value="/stud/stuqnaboard", method=RequestMethod.POST)
	public String searchBoardBySubjectCode (SearchForm searchForm, Model model, Student student) {
		List<Regisubject> regiList = regisubjectService.getRegisByUserNoService(student.getNo());
		List<Subject> subjectCode = new ArrayList<Subject>();
		
		
		searchForm.setSearchBoardType("Q");
		SiteMap siteMap = sitemapSerivce.getSitemapByCodeService(student.getDivision());
		
		searchForm.setDepartment(siteMap.getName());
		
		for (Regisubject subject : regiList) {
			Subject subjectL = new Subject();
			subjectL.setSubjectName(subject.getSubject().getSubjectName());
			subjectL.setDivision(subject.getSubject().getNo());
			
			subjectCode.add(subjectL);
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
		
		searchForm.setDisplay(10);
		
		List<Board> boardList = boardService.searchBoard(searchForm);
		
		
		model.addAttribute("subject", subjectCode);
		model.addAttribute("search", searchForm);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pagination", pageNation);
		
		return "/stuboard/stuqnaboard";
	}
	
	@RequestMapping(value="/stud/stuqnaboardform", method=RequestMethod.GET)
	public String stuQnaBoardForm(Student student,Model model){

		List<Regisubject> regiList = regisubjectService.getRegisByUserNoService(student.getNo());
		List<Subject> subjectCode = new ArrayList<Subject>();
		
		for (Regisubject subject : regiList) {
			Subject subjectL = new Subject();
			subjectL.setSubjectName(subject.getSubject().getSubjectName());
			subjectL.setDivision(subject.getSubject().getNo());
			subjectCode.add(subjectL);
		}
		model.addAttribute("boardForm", new BoardForm());
		model.addAttribute("subject", subjectCode);
		return "/stuboard/stuqnaboardform";
	}
	
	@RequestMapping(value="/stud/stuqnaboardform", method=RequestMethod.POST)
	public String stuQnaBoardAdd(@Valid BoardForm boardForm, Errors err, Student student){
		if (err.hasErrors()) {
			return "/stuboard/stuqnaboardform";
		}
		
		Board board = new Board();
		
		BeanUtils.copyProperties(boardForm, board);
		board.setSubjectNo(boardForm.getSubjectSelect());
		board.setWriter(student.getName());
		board.setCategory("Q");
		SiteMap siteMap = sitemapSerivce.getSitemapByCodeService(student.getDivision());
		
		board.setDepartment(siteMap.getName());
		boardService.addStuQnaBoard(board);
		
		return "redirect:/stud/stuqnaboard";
	}
	
	@RequestMapping(value="/stud/stuqnadetail", method=RequestMethod.GET)
	public String stuDetailBoard (@RequestParam int bno, Student student, Model model) {
		List<BoardView> viewUser = boardService.getBoardViewUser(bno);
		List<Review> reviewList = reviewService.getAllReviewByNo(bno);
		if (!viewUser.isEmpty()) {
			for (BoardView vUser : viewUser) {
				if (!student.getName().equals(vUser.getUserId())) {
					if (vUser.getBno() != bno){
						BoardView view = new BoardView();
						view.setBno(bno);
						view.setUserId(student.getName());
						boardService.addBoardView(view);
						boardService.updateCount(bno);
					}else {
						Board board = boardService.getBoard(bno);
						model.addAttribute("reviewList", reviewList);
						model.addAttribute("board", board);
						return "/stuboard/stuqnadetail";
					}
				}else {
					Board board = boardService.getBoard(bno);
					model.addAttribute("board", board);
					model.addAttribute("reviewList", reviewList);
					return "/stuboard/stuqnadetail";
				}
			}
		}else {
			BoardView view = new BoardView();
			view.setBno(bno);
			view.setUserId(student.getName());
			boardService.addBoardView(view);
			boardService.updateCount(bno);
		}
		Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		model.addAttribute("reviewList", reviewList);
		return "/stuboard/stuqnadetail";
	}
	
	// 리뷰등록
	@RequestMapping(value="/stud/addreview", method=RequestMethod.POST)
	public String addReview (@RequestParam int bno, String reviewContents,Student student) {
		
		Review review = new Review();
		if (reviewContents == null) {
			return "redirect:/stud/stuqnadetail?bno="+review.getGroupNo()+"&err=deny";
		}
		review.setGroupNo(bno);
		review.setContents(reviewContents);
		review.setWriter(student.getName());
		reviewService.addReview(review);
		
		return "redirect:/stud/stuqnadetail?bno="+bno;
	}
	
	// 리뷰 삭제 (본인확인)
	@RequestMapping(value="/stud/deleteReview", method=RequestMethod.GET)
	public String deleteReview (@RequestParam int rno, Student student){
			
			Review review = reviewService.getReviewByNo(rno);
			
			if (!student.getName().equals(review.getWriter())) {
				
				return "/stud/stuqnadetail?err=deny";
			}else {
				reviewService.deleteReview(rno);
			}
		
		return "redirect:/stud/stuqnadetail?bno="+review.getGroupNo();
	}
	
	// 학생 공지사항 
	@RequestMapping(value="/stud/stuNoticeBoarddetail")
	public String sutdentNoticeBoardDetail(@RequestParam int bno, Model model, Student student){
		List<BoardView> viewUser = boardService.getBoardViewUser(bno);
		List<Review> reviewList = reviewService.getAllReviewByNo(bno);
		if (!viewUser.isEmpty()) {
			for (BoardView vUser : viewUser) {
				if (!student.getName().equals(vUser.getUserId())) {
					if (vUser.getBno() != bno){
						BoardView view = new BoardView();
						view.setBno(bno);
						view.setUserId(student.getName());
						boardService.addBoardView(view);
						boardService.updateCount(bno);
					}else {
						Board board = boardService.getBoard(bno);
						model.addAttribute("reviewList", reviewList);
						model.addAttribute("board", board);
						return "/stuboard/studentnoticeboarddetail";
					}
				}else {
					Board board = boardService.getBoard(bno);
					model.addAttribute("board", board);
					model.addAttribute("reviewList", reviewList);
					return "/stuboard/studentnoticeboarddetail";
				}
			}
		}else {
			BoardView view = new BoardView();
			view.setBno(bno);
			view.setUserId(student.getName());
			boardService.addBoardView(view);
			boardService.updateCount(bno);
		}
		Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		model.addAttribute("reviewList", reviewList);
		return "/stuboard/studentnoticeboarddetail";
	}
	// 학생 공지사항 
		@RequestMapping(value="/stud/stuDeptBoarddetail")
		public String stuDeptBoarddetail(@RequestParam int bno, Model model, Student student){
			List<BoardView> viewUser = boardService.getBoardViewUser(bno);
			List<Review> reviewList = reviewService.getAllReviewByNo(bno);
			if (!viewUser.isEmpty()) {
				for (BoardView vUser : viewUser) {
					if (!student.getName().equals(vUser.getUserId())) {
						if (vUser.getBno() != bno){
							BoardView view = new BoardView();
							view.setBno(bno);
							view.setUserId(student.getName());
							boardService.addBoardView(view);
							boardService.updateCount(bno);
						}else {
							Board board = boardService.getBoard(bno);
							model.addAttribute("reviewList", reviewList);
							model.addAttribute("board", board);
							return "/stuboard/studdeptboarddetail";
						}
					}else {
						Board board = boardService.getBoard(bno);
						model.addAttribute("board", board);
						model.addAttribute("reviewList", reviewList);
						return "/stuboard/studdeptboarddetail";
					}
				}
			}else {
				BoardView view = new BoardView();
				view.setBno(bno);
				view.setUserId(student.getName());
				boardService.addBoardView(view);
				boardService.updateCount(bno);
			}
			Board board = boardService.getBoard(bno);
			model.addAttribute("board", board);
			model.addAttribute("reviewList", reviewList);
			return "/stuboard/studdeptboarddetail";
		}
	
}