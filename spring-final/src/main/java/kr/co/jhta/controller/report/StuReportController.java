package kr.co.jhta.controller.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.service.report.StuReportService;
import kr.co.jhta.service.sitemap.SitemapService;
import kr.co.jhta.service.user.RegisubjectService;
import kr.co.jhta.service.user.StudentService;
import kr.co.jhta.vo.Preport;
import kr.co.jhta.vo.PreportContent;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.stu.Regisubject;
import kr.co.jhta.vo.stu.Student;

@Controller
@RequestMapping("/stud")
public class StuReportController {

	@Autowired
	StuReportService stuRepService;
	
	@Autowired
	StudentService stuService;
	
	@Autowired
	SitemapService sitemapService;
	
	@Autowired
	RegisubjectService regisubjectService;
	
	private int nowScore = 0; 
	
	@RequestMapping(value="/deleteReprot")
	public String deleteReportStu(@RequestParam(value="cno") int cno,
			@RequestParam(value="eno") int eno, Student student, Model model) {
		stuRepService.deleteReportByCno(cno, student.getNo());
		model.addAttribute("eno", eno);
		return "redirect:/stud/ReportHome";
	}
	
	
	@RequestMapping(value="/showStuReport", method=RequestMethod.GET)
	public String showStuReport(@RequestParam(value="cno") int cno, @RequestParam(value="eno") int eno,
								Model model, Student student) {
	
		PreportContent stuReport = stuRepService.getStuReportByCnoService(cno);
		model.addAttribute("stuReport", stuReport);
		model.addAttribute("student", student);
		
		boolean isSamePerson = false;
		if(samePersonReportCheck(stuReport.getStudent().getNo(), student.getNo())) {
			isSamePerson = true;
		}
		
		if(isSamePerson){
			model.addAttribute("isSamePerson",isSamePerson);
			return "student/report/showStuReport";
		}		
		model.addAttribute("eno", eno);
		model.addAttribute("isSamePerson",isSamePerson);
		return "redirect:/stud/ReportHome";
	}
		
	@RequestMapping(value="/showProfReport", method=RequestMethod.GET)
	public String showProfReport(Model model, Student student, @RequestParam(value="pno") int pno) {
		
		Preport profReport = stuRepService.getProfReportByPnoService(pno);
		model.addAttribute("profReport", profReport);
		
		return "student/report/showProfReport";
	}
	
	@RequestMapping(value="/ReportHome", method=RequestMethod.GET)
	public String stuReportHome(Model model, Student student, @RequestParam(value="eno") int eno) {
			
		List<Preport> profReportList = stuRepService.getAllProfReportService(eno);
		
		if(!profReportList.isEmpty()) {
			model.addAttribute("profReportList", profReportList);			
		}
		List<PreportContent> stuReportList = stuRepService.getStuAllReportByEnoService(eno);
		if(!stuReportList.isEmpty()) {
			model.addAttribute("stuReportList", stuReportList);
		}
		
		return "student/report/stuReportHome";		
	}
	
	@RequestMapping(value="/stuReport", method=RequestMethod.GET)
	public String stuReportForm(Model model, Student student) {
		
		model.addAttribute("student", student);
		List<SiteMap> deptList = sitemapService.getAllSitemapPreService();
		model.addAttribute("deptList", deptList);
		
		nowScore = stuService.getNowScoreService(student.getNo());
		model.addAttribute("applyScore", nowScore);
		
		List<Regisubject> regisubList = regisubjectService.getRegisByUserNoService(student.getNo());
		if(!regisubList.isEmpty()) {
			model.addAttribute("regisubList" , regisubList);
		}
		
		return "student/report/stuReportForm";
	}
		
	
	public boolean samePersonReportCheck(int stuNoInStuReport, int stuNoInSessoin) {
		if(stuNoInStuReport == stuNoInSessoin) {
			return true;
		}
		return false;
	}
	

}
