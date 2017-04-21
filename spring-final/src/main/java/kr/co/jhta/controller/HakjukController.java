package kr.co.jhta.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.service.hakjuk.HakjukService;
import kr.co.jhta.service.professor.ProfessorService;
import kr.co.jhta.service.sitemap.SitemapService;
import kr.co.jhta.service.user.StudentService;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.hakjuk.LeaveSearchForm;
import kr.co.jhta.vo.hakjuk.ProfessorSearchForm;
import kr.co.jhta.vo.hakjuk.SearchForm;
import kr.co.jhta.vo.hakjuk.StudentSearchForm;
import kr.co.jhta.vo.stu.AddStudentForm;
import kr.co.jhta.vo.stu.Student;

@Controller
@RequestMapping("/admin")
public class HakjukController {
	
	@Autowired
	private SitemapService sitemapService;

	@Autowired
	private ProfessorService professorService;
		
	@Autowired
	private HakjukService hakjukService;
	
	
	/**
	 * 학생 정보 조회하는 화면
	 * @return
	 */
	@RequestMapping(value = "/searchstud",method=RequestMethod.GET)
	public String searchstudGET(Model model){
		model.addAttribute("studList",hakjukService.getAllStudentService());
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		return "collegeregister/searchstud";
	}
	
	/**
	 * 	조건이 있는 학생 Search 
	 */
	@RequestMapping(value = "/searchstud",method=RequestMethod.POST)
	public String searchstudPOST(StudentSearchForm ssf, Model model){
		System.out.println(ssf);
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		model.addAttribute("studList",hakjukService.searchStudent(ssf));
		return "collegeregister/searchstud";
	}
	
	/**
	 * 학생 id를 받아서 학생 하면 조회하여 상세정보 보여주는 페이지
	 * @param id
	 * @return
	 */
	
	@RequestMapping("/studinfo")
	public String studinfo(@RequestParam("id") String id,Model model){
		Student stud = hakjukService.getStudentByIdService(id);
		if(stud == null){
			return "redirect:/admin/searchstud";
		}
		model.addAttribute("stud",stud);
		return "collegeregister/studinfo";
	}
	
	/**
	 * 교수 정보 조회하는 화면
	 * @return
	 */
	
	@RequestMapping("/searchprof")
	public String searchprof(Model model){
		model.addAttribute("profList",hakjukService.getAllProfessorService()); // 모든 교수를 조회하여 jsp에 전달
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService()); // 대학 정보 전달
		return "collegeregister/searchprof";
	}
	/**
	 * 조건이 있는 학생 정보 조회
	 * @param ssf
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value = "/searchprofcon",method=RequestMethod.POST)
	public String searchprofPOST(ProfessorSearchForm ssf, Model model){
		System.out.println(ssf);
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		model.addAttribute("profList",hakjukService.searchProfessor(ssf));
		return "collegeregister/searchprof";
	}
	
	
	/**
	 * 교수 id를 받아서 교수 하면 조회하여 상세정보 보여주는 페이지
	 * @param id
	 * @return
	 */
	@RequestMapping("/profinfo")
	public String profinfo(@RequestParam("id") String id,Model model){
		Professor prof = hakjukService.getProfessorByIdService(id);
		if(prof == null){
			return "redirect:/admin/searchprof";
		}
		model.addAttribute("prof",prof);
		return "collegeregister/profinfo";
	}
	 
	/**
	 * 입학생 조회목록
	 * @return
	 */
	@RequestMapping("/admissions") 
	public String admissions(Model model){
		List<SiteMap> sitemap = sitemapService.getAllSitemapPreService();
		List<Student> studList = hakjukService.getAllAdmissionStudService();
		model.addAttribute("sitemapList",sitemap);
		model.addAttribute("studList",studList);
		return "collegeregister/admissions";
	}
	/**
	 * 입학생 등록 화면
	 * @param model
	 * @return
	 */
	@RequestMapping("/admissionstud")
	public String admissionstud(Model model){
		List<SiteMap> sitemapList = sitemapService.getAllSitemapPreService();
		SiteMap sitemap = new SiteMap();
		sitemap.setPreCode(sitemapList.get(0).getCode());
		List<SiteMap> subsitemapList = sitemapService.getAllSitemapSecService(sitemap);
		List<Professor> profList = professorService.getProListByTCode(sitemapList.get(0).getCode());
		model.addAttribute("sitemapList",sitemapList);
		model.addAttribute("majors",subsitemapList);
		model.addAttribute("professors",profList);
		return "collegeregister/admissionstud";
	}
	
	@RequestMapping(value="/searchadmission", method=RequestMethod.POST)
	public String searchadmission(SearchForm ssf, Model model){
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		model.addAttribute("studList",hakjukService.searchAdmissionStudent(ssf));
		return "collegeregister/admissions";
	}
	
	
	/**
	 * 
	 * 입학생 등록화면에서 submit시 학생 등록하고 입학생 조회목록으로 보는 메소드
	 * @return
	 */
	@RequestMapping(value="/addstud", method=RequestMethod.POST)
	public String addstudent(String studemail,String studemailaddr,AddStudentForm addstud){
		
		String email = studemail+"@"+studemailaddr;
		System.out.println(addstud);
		Student stud = new Student();
		stud.setEmail(email);
		stud.setPwd(addstud.getSsn().split("-")[0]);
		BeanUtils.copyProperties(addstud, stud);
		stud.setProfessor(addstud.getProfessor());
		hakjukService.admissionsStud(stud);
		return "redirect:/admin/admissionstud";
	}
	
	/**
	 * 미승인 된 휴학 목록을 표시하는 화면
	 * @return
	 */
	@RequestMapping("/leave")
	public String leavesearchGET(Model model){
		model.addAttribute("leaveList",hakjukService.getAllLeaveByFalseService());
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		return "collegeregister/leave";
	}
	/**
	 * 조건에 맞춰서 휴학 신청 목록을 조회하는 화면
	 * @param lsf
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/leave",method=RequestMethod.POST)
	public String leavesearchPOST(LeaveSearchForm lsf ,Model model){
		model.addAttribute("leaveList",hakjukService.getAllLeaveByFalseForm(lsf));
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		return "collegeregister/leave";
	}
	/**
	 * 처리 된 휴학 목록 표시
	 * @param model
	 * @return
	 */
	@RequestMapping("/enterleave")
	public String enterleaveGET(Model model){
		model.addAttribute("leaveList",hakjukService.getAllLeaveByTrueService());
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		return "collegeregister/enterleave";
	}
	/**
	 * 조건에 맞춰서 휴학 처리된 목록 표시
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/enterleave", method=RequestMethod.POST)
	public String enterleaveGET(LeaveSearchForm lsf ,Model model){
		model.addAttribute("leaveList",hakjukService.getAllLeaveByTrueForm(lsf));
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		return "collegeregister/enterleave";
	}
	@RequestMapping(value = "/leaveinfo", method=RequestMethod.GET)
	public String enterleaveGET(String id,Model model){
		System.out.println(id);
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		return "collegeregister/leaveinfo";
	}
	
	
	
	/**
	 * 복학 목록 화면
	 * @return
	 */
	@RequestMapping("/reinstatement")
	public String reinstatement(){
		return "collegeregister/reinstatement";
	}

	/**
	 * 제적 화면
	 * @return
	 */
	@RequestMapping("/disenrollment")
	public String disenrollment(){
		return "collegeregister/disenrollment";
	}
}

