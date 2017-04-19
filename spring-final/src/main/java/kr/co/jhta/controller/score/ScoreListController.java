package kr.co.jhta.controller.score;

import java.util.ArrayList;
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
import kr.co.jhta.service.major.SemesterService;
import kr.co.jhta.service.major.SubjectService;
import kr.co.jhta.service.score.AttendanceService;
import kr.co.jhta.service.score.ReportService;
import kr.co.jhta.service.score.ScoreService;
import kr.co.jhta.service.sitemap.SitemapService;
import kr.co.jhta.vo.Attendance;
import kr.co.jhta.vo.Report;
import kr.co.jhta.vo.Score;
import kr.co.jhta.vo.Scorelist;
import kr.co.jhta.vo.Semester;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.stu.Regisubject;
import kr.co.jhta.vo.stu.Student;

@Controller
public class ScoreListController {
	
	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private SemesterService semesterSevice;
	
	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private SitemapService sitemapService;
				
	@RequestMapping("/scorelist.do")
	public String scorelist(Model model){
		
		List<Score> scorelist = scoreService.getAllScoreList();
		List<Scorelist> scorelist2 = new ArrayList<Scorelist>();
		List<Semester> semesterlist = semesterSevice.getAllSemester();
		List<Subject> subjectlist = subjectService.getAllList();
		List<SiteMap> sitemaplist = sitemapService.getAllSitemapPreService();
		
		for(Score score : scorelist){
			Scorelist list = new Scorelist();
			
			score.setRegister(scoreService.getRegiListByNo(score.getRegister().getRegiNo()));
			Subject sub = scoreService.getSubjectInfoByNo(score.getRegister().getjNo());
			Student stu = scoreService.getStudentInfoByNo(score.getRegister().getStuNo());
			Attendance att = attendanceService.getAttendanceListByScoreNo(score.getNo());
			Report report = reportService.getReportByScoreNo(score.getNo());
			sub.setSelectNo(scoreService.getSemesterByNo(sub.getSelectNo().getNo()));
			System.out.println(sub);
			
			list.setStudent(stu);
			list.setSubject(sub);
			list.setScore(score);
			list.setNo(score.getRegister().getRegiNo());
			list.setAtt(att);
			list.setReport(report);
			
			scorelist2.add(list);
		}
		model.addAttribute("scorelist2", scorelist2);
		model.addAttribute("semesterlist", semesterlist);
		model.addAttribute("subjectlist", subjectlist);
		model.addAttribute("sitemaplist",sitemaplist);
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
		System.out.println(score);
		return sitemapService.getAllSitemapSecService(sitemap);
	}
	
	@RequestMapping(value="/scoreSearchInfo", method=RequestMethod.POST)
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
