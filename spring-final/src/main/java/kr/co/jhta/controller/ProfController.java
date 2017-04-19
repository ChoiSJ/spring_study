package kr.co.jhta.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.service.major.SemesterService;
import kr.co.jhta.service.major.SubjectService;
import kr.co.jhta.service.professor.ProfessorService;
import kr.co.jhta.service.professor.SyllabusService;
import kr.co.jhta.service.user.EnrollService;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.Semester;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.SubjectAddForm;
import kr.co.jhta.vo.SubjectIsPassed;
import kr.co.jhta.vo.Syllabus;
import kr.co.jhta.vo.Syllabusform;
import kr.co.jhta.vo.stu.Enroll;
import kr.co.jhta.vo.stu.EnrollForm;

@Controller
@RequestMapping("/prof")
public class ProfController {
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private SyllabusService syllabusService;
	
	@Autowired
	private SemesterService semesterService;
	
	@Autowired
	private EnrollService enrollService;
	
	@RequestMapping("/home")
	public String testMain() {
		return "/prof/profMain";
	}
	
	@RequestMapping("/syllabus")
	public String syllAbus(@RequestParam("no") int no,Model model, Syllabus syll){
		Syllabus syno = syllabusService.getByNoList(syll.getNo());
		model.addAttribute("syno",syno);
		return "/prof/syllabus";
	}
	@RequestMapping(value="/syllform", method=RequestMethod.GET)
	public String syllForm(Model model, HttpSession session){
		Professor prof = (Professor) session.getAttribute("LOGIN_USER");
		model.addAttribute("prof", prof);
		List<Subject> subList = subjectService.getByProIdList(prof.getId());
		model.addAttribute("subList", subList);
		model.addAttribute("syllabusform", new Syllabusform());
		
		return "/prof/syllabusform";
	}
	@RequestMapping(value="/syllupdate", method=RequestMethod.GET)
	public String syllUpForm(@RequestParam("no") int no,Model model, Syllabus syll){
		Syllabus syno = syllabusService.getByNoList(syll.getNo());
		model.addAttribute("syno", syno);
		List<Professor> proList = professorService.proAllList();
		model.addAttribute("proList", proList);
		List<Subject> subList = subjectService.getAllList();
		model.addAttribute("subList", subList);
		model.addAttribute("syllabusform", new Syllabusform());
		
		
		return "/prof/syllupdate";
	}
	
	@RequestMapping(value="/syllupdate", method=RequestMethod.POST)
	public String syllUpdate(@RequestParam("no") int no,@Valid @ModelAttribute("syllabusform")Syllabusform syllform, Errors errors) throws Exception{
		if(errors.hasErrors()){
			System.out.println(errors.getAllErrors());
			return "/prof/syllabusform";
		}
		Syllabus syllabus = new Syllabus();
		Subject subject = new Subject();
		subject.setNo(syllform.getSubno());
		syllabus.setSubject(subject);
		Professor prof = new Professor();
		prof.setId(syllform.getId());
		syllabus.setNo(no);
		syllabus.setProfessor(prof);
		BeanUtils.copyProperties(syllform, syllabus);
		syllabusService.updateSyll(syllabus);
		System.out.println(syllabus);
		return "redirect:/prof/syllinfo";
	}
	
	@RequestMapping(value="/syllform", method=RequestMethod.POST)
	public String addNewSyll(@Valid @ModelAttribute("syllabusform")Syllabusform syllform, Errors errors) throws Exception{
		
		System.out.println(syllform);
		if(errors.hasErrors()){
			System.out.println(errors.getAllErrors());
			return "/prof/syllabusform";
		}
		Syllabus syllabus = new Syllabus();
		Subject subject = new Subject();
		subject.setNo(syllform.getSubno());
		syllabus.setSubject(subject);
		Professor prof = new Professor();
		prof.setId(syllform.getId());
		syllabus.setProfessor(prof);
		BeanUtils.copyProperties(syllform, syllabus);
		syllabusService.addNewSyll(syllabus);
		return "redirect:/prof/syllinfo";
	}
	@RequestMapping(value="/addsubform", method=RequestMethod.POST)
	public String addsub(@Valid @ModelAttribute("subjackform")SubjectAddForm subjackform, Errors errors) throws Exception{
		System.out.println(subjackform);
		if(errors.hasErrors()){
			System.out.println(errors.getAllErrors());
			return "/prof/addsubjectform";
		}
		Subject subject = new Subject();
		SiteMap sitemap = new SiteMap();
		sitemap.setCode(subjackform.getCode());
		subject.setSiteCode(sitemap);
		Professor prof = new Professor();
		prof.setId(subjackform.getProfessor());
		subject.setProfessor(prof);
		Semester seme = new Semester();
		seme.setNo(subjackform.getSelectNo());
		subject.setSelectNo(seme);
		SubjectIsPassed pass = new SubjectIsPassed();
		pass.setCode(subjackform.getIsPassed());
		subject.setPassed(pass);
		
		BeanUtils.copyProperties(subjackform, subject);
		subjectService.addSubject2(subject);
		return "redirect:/prof/subinfo";
	}
	@RequestMapping("/syllinfo")
	public String syllInfo(Model model, HttpSession session){
		Professor prof = (Professor) session.getAttribute("LOGIN_USER");
		List<Syllabus> syllList = syllabusService.getByProNoList(prof.getId());
		model.addAttribute("syllList", syllList);
		return "/prof/syllabusInfo";
	}
	
	@RequestMapping("/sylldel")
	public String complete(@RequestParam("no") int no, Syllabus syllabus){
		syllabusService.deleteSyll(syllabus.getNo());
		
		
		return "redirect:/prof/syllinfo";
	}
	
	@RequestMapping(value="/addsubform", method=RequestMethod.GET)
	public String addsubform(@Valid @ModelAttribute("subjackform")SubjectAddForm subjackform,Model model, HttpSession session){
		Professor prof = (Professor) session.getAttribute("LOGIN_USER");
		model.addAttribute("prof", prof);
		List<SubjectIsPassed> passList = subjectService.getPassAllList();
		model.addAttribute("passList", passList);
		List<Semester> semeList = semesterService.getAllSemester();
		model.addAttribute("semeList", semeList);
		return "/prof/addsubjectform";
	}
	
	@RequestMapping(value="/addenrollform", method=RequestMethod.GET)
	public String addenrollform(@Valid @ModelAttribute("enrollform")EnrollForm enrollform, Model model, HttpSession session){
		Professor prof = (Professor) session.getAttribute("LOGIN_USER");
		List<Subject> subList = subjectService.getByProIdList(prof.getId());
		model.addAttribute("subList", subList);
		return "/prof/addenrollform2";
	}
	@RequestMapping(value="/addenrollform", method=RequestMethod.POST)
	public String addenroll(@Valid @ModelAttribute("enrollform")EnrollForm enrollform,Errors errors){
		System.out.println(enrollform);
		if(errors.hasErrors()){
			System.out.println(errors.getAllErrors());
			return "/prof/addsubjectform";
		}
		Enroll enroll = new Enroll();
		Subject subject = new Subject();
		subject.setNo(enrollform.getSubjectNo());
		
		
		
		return "redirect:/prof/subinfo";
	}
	
	
	@RequestMapping("/subinfo")
	public String subinfo(Model model, HttpSession session){
		Professor prof = (Professor) session.getAttribute("LOGIN_USER");
		List<Subject> subList = subjectService.getByProIdList(prof.getId());
		model.addAttribute("subList", subList);
		
		return "/prof/subinfo";
	}
	@RequestMapping("/subdel")
	public String deleteSub(@RequestParam("no") int no, Subject subject){
		subjectService.deleteSub(subject.getNo());
		
		
		return "redirect:/prof/subinfo";
	}
	@RequestMapping("/subdetail")
	public String subdetail(@RequestParam("no")int no, Model model, Subject sub){
		
		Subject subno = subjectService.getByNoList(sub.getNo());
		model.addAttribute("subno", subno);
		return "/prof/subdetail";
	}
	@RequestMapping(value="/subupdate", method=RequestMethod.GET)
	public String subupdateform(@RequestParam("no")int no, Model model, @Valid @ModelAttribute("subjackform")SubjectAddForm subjackform, Subject sub){
		Subject subno = subjectService.getByNoList(sub.getNo());
		model.addAttribute("subno", subno);
		List<SubjectIsPassed> passList = subjectService.getPassAllList();
		model.addAttribute("passList", passList);
		List<Semester> semeList = semesterService.getAllSemester();
		model.addAttribute("semeList", semeList);
		
		return "/prof/subupdate";
	}
	@RequestMapping(value="/subupdate", method=RequestMethod.POST)
	public String subupdate(@RequestParam("no") int no,@Valid @ModelAttribute("subjackform")SubjectAddForm subjackform, Errors errors) throws Exception{
		System.out.println(subjackform);
		if(errors.hasErrors()){
			System.out.println(errors.getAllErrors());
			return "/prof/addsubjectform";
		}
		Subject subject = new Subject();
		subject.setNo(no);
		Professor prof = new Professor();
		prof.setId(subjackform.getProfessor());
		subject.setProfessor(prof);
		Semester seme = new Semester();
		seme.setNo(subjackform.getSelectNo());
		subject.setSelectNo(seme);
		SubjectIsPassed pass = new SubjectIsPassed();
		pass.setCode(subjackform.getIsPassed());
		subject.setPassed(pass);
		SiteMap site = new SiteMap();
		site.setCode(subjackform.getCode());
		subject.setSiteCode(site);
		BeanUtils.copyProperties(subjackform, subject);
		subjectService.subupdate(subject);
		return "redirect:/prof/subinfo";
	}
	
}
