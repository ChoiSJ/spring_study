package kr.co.jhta.controller.hakjuk;

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
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.hakjuk.AddProfForm;
import kr.co.jhta.vo.hakjuk.Dropoff;
import kr.co.jhta.vo.hakjuk.LeaveSearchForm;
import kr.co.jhta.vo.hakjuk.ProfessorSearchForm;
import kr.co.jhta.vo.hakjuk.ReinForm;
import kr.co.jhta.vo.hakjuk.Reinstatement;
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
	
	@RequestMapping(value = "/home",method=RequestMethod.GET)
	public String home(Model model){
		return "home";
	}
	
	
	/**
	 * 학생 정보 조회하는 화면
	 * @return
	 */
	@RequestMapping(value = "/searchstud",method=RequestMethod.GET)
	public String searchstudGET(Model model){
		model.addAttribute("studList",hakjukService.getAllStudentService());
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		model.addAttribute("rows",hakjukService.getAllStudentService().size());
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
		model.addAttribute("rows",hakjukService.searchStudent(ssf).size());
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
	 * 
	 *	학생 정보 수정화면 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updatestud",method=RequestMethod.GET)
	public String updateStud(String id,Model model){
		Student student = hakjukService.getStudentByIdsecondService(id);
		List<SiteMap> sitemapList = sitemapService.getAllSitemapPreService();
		SiteMap sitemap = hakjukService.getSiteMapByNameService(student.getDivision());
		List<SiteMap> subsitemapList = sitemapService.getAllSitemapSecService(sitemap);
		List<Professor> profList = professorService.getProListByTCode(sitemap.getCode());
		model.addAttribute("sitemapList",sitemapList); // 대학 정보 전달
		model.addAttribute("studSitemap",sitemap); // 해당 학생의 대학/학과 정보 전달
		model.addAttribute("majors",subsitemapList); // 학과 정보 전달
		model.addAttribute("professors",profList); // 해당 학과 내의 모든 교수 조회
		model.addAttribute("student",student);
		return "collegeregister/updatestud";
	}
	/**
	 * 학생 정보 수정 후 submit되서 오는 class
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updatestud",method=RequestMethod.POST)
	public String updateStudPost(AddStudentForm asf,String studemail,String studemailaddr,Model model){
		asf.setEmail(studemail+"@"+studemailaddr);
		hakjukService.updateStudentService(asf);
		return "redirect:/admin/searchstud";
	}
	
	
	/**
	 * 교수 정보 조회하는 화면
	 * @return
	 */
	
	@RequestMapping("/searchprof")
	public String searchprof(Model model){
		model.addAttribute("profList",hakjukService.getAllProfessorService()); // 모든 교수를 조회하여 jsp에 전달
		model.addAttribute("rows",hakjukService.getAllProfessorService().size());
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService()); // 대학 정보 전달
		return "collegeregister/searchprof";
	}
	/**
	 * 조건이 있는 교수 정보 조회
	 * @param ssf
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value = "/searchprofcon",method=RequestMethod.POST)
	public String searchprofPOST(ProfessorSearchForm ssf, Model model){
		System.out.println(ssf);
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		model.addAttribute("profList",hakjukService.searchProfessor(ssf));
		model.addAttribute("rows",hakjukService.searchProfessor(ssf).size());
		return "collegeregister/searchprof";
	}
	
	
	/**
	 * 교수 id를 받아서 교수 한명 조회하여 상세정보 보여주는 페이지
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
	 * 교수 수정 화면
	 * @param id
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value = "/updateprof",method=RequestMethod.GET)
	public String updateProf(String id,Model model){
		Professor prof = hakjukService.getProfessorByIdService(id);
		List<SiteMap> sitemapList = sitemapService.getAllSitemapPreService();
		SiteMap sitemap = hakjukService.getSiteMapByNameService(prof.getDivision());
		List<SiteMap> subsitemapList = sitemapService.getAllSitemapSecService(sitemap);
		model.addAttribute("sitemapList",sitemapList); // 대학 정보 전달
		model.addAttribute("profSitemap",sitemap); // 해당 교수의 대학/학과 정보 전달
		model.addAttribute("majors",subsitemapList); // 학과 정보 전달
		model.addAttribute("professor",prof);
		return "collegeregister/updateprof";
	}
	@RequestMapping(value = "/updateprof",method=RequestMethod.POST)
	public String updateProfPost(AddProfForm apf,String studemail,String studemailaddr){
		apf.setEmail(studemail+"@"+studemailaddr);
		apf.setCode(apf.getDivision());
		System.out.println(apf);
		hakjukService.updateProfessorService(apf);
		return "redirect:/admin/searchprof";
	}
	/**
	 * 입학생 조회목록
	 * @return
	 */
	@RequestMapping("/searchadmission") 
	public String admissions(Model model){
		List<SiteMap> sitemap = sitemapService.getAllSitemapPreService();
		List<Student> studList = hakjukService.getAllAdmissionStudService();
		model.addAttribute("sitemapList",sitemap);
		model.addAttribute("rows",studList.size());
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
		List<Professor> profList = professorService.getProListByTCode(subsitemapList.get(0).getCode());
		model.addAttribute("sitemapList",sitemapList);
		model.addAttribute("majors",subsitemapList);
		model.addAttribute("professors",profList);
		return "collegeregister/admissionstud";
	}
	/**
	 * 조건에 맞는 입학생 정보 조회
	 * @param ssf
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/searchadmission", method=RequestMethod.POST)
	public String searchadmission(SearchForm ssf, Model model){
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		model.addAttribute("studList",hakjukService.searchAdmissionStudent(ssf));
		model.addAttribute("rows",hakjukService.searchAdmissionStudent(ssf).size());
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
		hakjukService.admissionsStud(stud,stud.getRegister());
		return "redirect:/admin/admissionstud";
	}
	
	/**
	 * 교수 정보 등록화면
	 * @param model
	 * @return
	 */
	@RequestMapping("/admissionprof")
	public String admissionprof(Model model){
		List<SiteMap> sitemapList = sitemapService.getAllSitemapPreService();
		SiteMap sitemap = new SiteMap();
		sitemap.setPreCode(sitemapList.get(0).getCode());
		List<SiteMap> subsitemapList = sitemapService.getAllSitemapSecService(sitemap);
		model.addAttribute("sitemapList",sitemapList);
		model.addAttribute("majors",subsitemapList);
		return "collegeregister/admissionprof";
	}
	/**
	 * 교수정보 등록화면에서 등록 버튼 submit 시 insert문
	 * @param studemail
	 * @param studemailaddr
	 * @param addstud
	 * @return
	 */
	
	@RequestMapping(value="/addprof", method=RequestMethod.POST)
	public String addprofessor(String studemail,String studemailaddr,AddProfForm addprof){
		
		String email = studemail+"@"+studemailaddr;
		addprof.setAddr(addprof.getAddr1()+addprof.getAddr2());
		addprof.setEmail(email);
		addprof.setCode(addprof.getDivision());
		addprof.setPwd(addprof.getSsn().split("-")[0]);
		hakjukService.addProfessorService(addprof);
		return "redirect:/admin/searchprof";
	}
	
	
	/**
	 * 미승인 된 휴학 목록을 표시하는 화면
	 * @return
	 */
	@RequestMapping("/leave")
	public String leavesearchGET(Model model){
		model.addAttribute("leaveList",hakjukService.getAllLeaveByFalseService());
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		model.addAttribute("rows",hakjukService.getAllLeaveByFalseService().size());
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
		model.addAttribute("rows",hakjukService.getAllLeaveByFalseForm(lsf).size());
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
		model.addAttribute("rows",hakjukService.getAllLeaveByTrueService().size());
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
		model.addAttribute("rows",hakjukService.getAllLeaveByTrueForm(lsf).size());
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		return "collegeregister/enterleave";
	}
	@RequestMapping(value = "/leaveinfo", method=RequestMethod.GET)
	public String enterleaveGET(String id,Model model){
		System.out.println(id);
		Student stud = hakjukService.getStudentByIdService(id);
		if(stud == null){
			return "redirect:/admin/leave";
		}
		model.addAttribute("leaveList",hakjukService.getAllEnrolledLeaveByStuNoService(stud.getNo()));
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		model.addAttribute("student",stud);
		return "collegeregister/leaveinfo";
	}
	
	@RequestMapping(value = "/leaveinfoOk", method=RequestMethod.GET)
	public String enterleaveOk(String id,Model model){
		System.out.println(id);
		Student stud = hakjukService.getStudentByIdService(id);
		if(stud == null){
			return "redirect:/admin/leave";
		}
		model.addAttribute("leaveList",hakjukService.getLeaveByNoOkService(stud.getNo()));
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		model.addAttribute("student",stud);
		return "collegeregister/leaveinfook";
	}
	
	@RequestMapping(value="/leaveOk")
	public String leaveOk(int no){
		hakjukService.updateLeaveByOkService(no);
		return "redirect:/admin/leave";
	}
	
	@RequestMapping(value="/leaveCancel")
	public String leaveCancel(int no){
		hakjukService.updateLeaveByCancelService(no);
		return "redirect:/admin/leave";
	}
		
	/**
	 * 복학 목록 화면
	 * @return
	 */
	@RequestMapping("/reinstatement")
	public String reinstatement(Model model){
		model.addAttribute("reinList",hakjukService.getAllReinFalseService());
		model.addAttribute("rows",hakjukService.getAllReinFalseService().size());
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		return "collegeregister/reinstatement";
	}
	@RequestMapping(value="/reinstatementform",method=RequestMethod.POST)
	public String reinstatementForm(ReinForm rf, Model model){
		System.out.println(rf);
		model.addAttribute("reinList",hakjukService.getReinFalseByFormService(rf));
		model.addAttribute("rows",hakjukService.getAllReinFalseService().size());
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		return "collegeregister/reinstatement";
	}
	
	/**
	 * 복학 승인 목록보기
	 * @param model
	 * @return
	 */
	@RequestMapping("/enterreinstatement")
	public String enterreinstatement(Model model){
		model.addAttribute("reinList",hakjukService.getAllReinTrueService());
		model.addAttribute("rows",hakjukService.getAllReinTrueService().size());
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		return "collegeregister/enterreinstatement";
	}
	@RequestMapping(value = "/enterreinstatementform",method=RequestMethod.POST)
	public String enterreinstatementForm(ReinForm rf, Model model){
		System.out.println(rf);
		model.addAttribute("reinList",hakjukService.getReinTrueByFormService(rf));
		model.addAttribute("rows",hakjukService.getAllReinFalseService().size());
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		return "collegeregister/enterreinstatement";
	}
	
	/**
	 * 복학 상세정보 보기
	 * @param no
	 * @param model
	 * @return
	 */
	@RequestMapping("/reininfo")
	public String reininfo(int no, Model model){
		Reinstatement reinstatement = hakjukService.getReinByNoService(no);
		if(reinstatement == null){
			return "redirect:/admin/reinstatement";
		}
		if(!reinstatement.getPass().equals("false")){
			return "redirect:/admin/reinstatement";
		}
		System.out.println(reinstatement);
		System.out.println(reinstatement.getStudent().getId());
		model.addAttribute("student",hakjukService.getStudentByIdService(reinstatement.getStudent().getId()));
		model.addAttribute("leaves",hakjukService.getLeaveByNoService(reinstatement.getLeave().getNo()));
		model.addAttribute("rein",reinstatement);
		return "collegeregister/reininfo";
	}
	
	/**
	 * 복학 상세정보 보기
	 * @param no
	 * @param model
	 * @return
	 */
	@RequestMapping("/reininfoOK")
	public String reininfoOK(int no, Model model){
		Reinstatement reinstatement = hakjukService.getReinByNoService(no);
		if(reinstatement == null){
			return "redirect:/admin/reinstatement";
		}
		System.out.println(reinstatement);
		System.out.println(reinstatement.getStudent().getId());
		model.addAttribute("student",hakjukService.getStudentByIdService(reinstatement.getStudent().getId()));
		model.addAttribute("rein",reinstatement);
		return "collegeregister/reininfoOK";
	}
	
	/**
	 * 복학 승인 완료 후 학적 업데이트
	 * @param no
	 * @param model
	 * @return
	 */
	@RequestMapping("/reinOK")
	public String reinok(int no, Model model){
		hakjukService.updateReinByOkService(no);
		return "redirect:/admin/reinstatement";
	}
	
	/**
	 * 제적 화면
	 * @return
	 */
	@RequestMapping("/disenrollment")
	public String disenrollment(){
		return "collegeregister/disenrollment";
	}
	
	/**
	 * 자퇴신청 목록
	 * @param model
	 * @return
	 */
	@RequestMapping("/dropoff")
	public String dropoff(Model model){
		model.addAttribute("dropList",hakjukService.getAllDropoffByFalseService());
		model.addAttribute("rows",hakjukService.getAllDropoffByFalseService().size());
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		return "collegeregister/dropoff";
	}
	/**
	 * 검색 조건이 있는 자퇴신청 목록 조회
	 * @param rf
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/dropoff", method=RequestMethod.POST)
	public String dropoffForm(ReinForm rf,Model model){
		model.addAttribute("dropList",hakjukService.getAllDropoffByFalseFormService(rf));
		model.addAttribute("rows",hakjukService.getAllDropoffByFalseFormService(rf).size());
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		return "collegeregister/dropoff";
	}
	/**
	 * 자퇴 신청한 학생의 정보 및 자퇴신청 내역
	 * @param no
	 * @param model
	 * @return
	 */
	@RequestMapping("/dropinfo")
	public String dropinfo(int no, Model model){
		System.out.println(no);
		Dropoff drop = hakjukService.getDropoffByFalseNOService(no);
		Student student = hakjukService.getStudentByIdService(drop.getStudent().getId());
		model.addAttribute("drop",drop);
		model.addAttribute("student",student);
		return "collegeregister/dropinfo";
	}
	/**
	 * 자퇴 승인처리가 된 하나의 자퇴를 확인
	 * @param no
	 * @param model
	 * @return
	 */
	@RequestMapping("/dropinfoOK")
	public String dropinfook(int no, Model model){
		System.out.println(no);
		Dropoff drop = hakjukService.getDropoffByNotFalseNOService(no);
		Student student = hakjukService.getStudentByIdService(drop.getStudent().getId());
		model.addAttribute("drop",drop);
		model.addAttribute("student",student);
		return "collegeregister/dropinfoOK";
	}
	
	/**
	 * 자퇴 승인 업데이트
	 * @param no
	 * @return
	 */
	@RequestMapping("/dropOK")
	public String dropOK(int no){
		hakjukService.updateDropOK(no);
		return "redirect:/admin/dropoff";
	}
	/**
	 * 자퇴 거절 업데이트
	 * @param no
	 * @return
	 */
	@RequestMapping("/dropCancel")
	public String dropCancel(int no){
		hakjukService.updateDropNOT(no);
		return "redirect:/admin/dropoff";
	}
	
	@RequestMapping("/enterdropoff")
	public String enterdropoff(Model model){
		model.addAttribute("dropList",hakjukService.getAllDropoffByNotFalseService());
		model.addAttribute("rows",hakjukService.getAllDropoffByFalseService().size());
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		return "collegeregister/enterdropoff";
	}
	
	@RequestMapping(value = "/enterdropoff",method=RequestMethod.POST)
	public String enterdropoff(ReinForm rf,Model model){
		System.out.println(rf);
		model.addAttribute("dropList",hakjukService.getAllDropoffByNotFalseFormService(rf));
		model.addAttribute("rows",hakjukService.getAllDropoffByNotFalseFormService(rf).size());
		model.addAttribute("sitemapList",sitemapService.getAllSitemapPreService());
		return "collegeregister/enterdropoff";
	}
	
}

