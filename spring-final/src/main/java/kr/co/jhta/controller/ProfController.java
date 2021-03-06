package kr.co.jhta.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.service.major.SubjectService;
import kr.co.jhta.service.professor.ProfessorService;
import kr.co.jhta.service.professor.SyllabusService;
import kr.co.jhta.service.user.EnrollService;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.ProfessorForm;
import kr.co.jhta.vo.Subject;
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
	private EnrollService enrollService;
	
	
	@RequestMapping("/home")
	public String testMain() {
		return "/timechart/proftimechart";
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
		List<Enroll> pList = enrollService.getProfEnroll(prof.getId());
		
		model.addAttribute("pList",pList);
		System.out.println(pList);
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
	public String addNewSyll(@Valid @ModelAttribute("syllabusform")Syllabusform syllform, Errors errors, Model model) throws Exception{
		
		System.out.println(syllform);
		if(errors.hasErrors()){
			System.out.println(errors.getAllErrors());
			return "/prof/syllabusform";
		}
		List<Syllabus> syll = syllabusService.getAllList();
		Syllabus syllabus = new Syllabus();
		Subject subject = new Subject();
		subject.setNo(syllform.getSubno());
		syllabus.setSubject(subject);
		Professor prof = new Professor();
		prof.setId(syllform.getId());
		syllabus.setProfessor(prof);
		boolean sylPass= false;
		for(Syllabus sy : syll){
			if(sy.getSubname().equals(syllform.getSubname())){
				sylPass = true;
				model.addAttribute("sylPass",sylPass);
				System.out.println("중복값 발생");
				return "redirect:/prof/syllform";
			}
		}
		BeanUtils.copyProperties(syllform, syllabus);
		syllabusService.addNewSyll(syllabus);
		return "redirect:/prof/syllinfo";
	}
	/*@RequestMapping(value="/addsubform", method=RequestMethod.POST)
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
		pass.setCode(subjackform.getPassed());
		subject.setPassed(pass);
		
		BeanUtils.copyProperties(subjackform, subject);
		subjectService.addSubject2(subject);
		return "redirect:/prof/subinfo";
	}*/
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
	
	/*@RequestMapping(value="/addsubform", method=RequestMethod.GET)
	public String addsubform(@Valid @ModelAttribute("subjackform")SubjectAddForm subjackform,Model model, HttpSession session){
		Professor prof = (Professor) session.getAttribute("LOGIN_USER");
		model.addAttribute("prof", prof);
		List<SubjectIsPassed> passList = subjectService.getPassAllList();
		model.addAttribute("passList", passList);
		List<Semester> semeList = semesterService.getAllSemester();
		model.addAttribute("semeList", semeList);
		return "/prof/addsubjectform";
	}*/
	
	@RequestMapping(value="/addenrollform", method=RequestMethod.GET)
	public String addenrollform(@Valid @ModelAttribute("enrollform")EnrollForm enrollform, Model model, HttpSession session){
		Professor prof = (Professor) session.getAttribute("LOGIN_USER");
		List<Subject> subList = subjectService.getByProIdList(prof.getId());
		model.addAttribute("subList", subList);
		return "/prof/addenrollform2";
	}
	@RequestMapping(value="/addenrollform", method=RequestMethod.POST)
	public String addenroll(@Valid @ModelAttribute("enrollform")EnrollForm enrollform,Errors errors, HttpSession session,Model model){
		Professor prof = (Professor) session.getAttribute("LOGIN_USER");
		System.out.println(enrollform);
		if(errors.hasErrors()){
			System.out.println(errors.getAllErrors());
			return "/prof/addsubjectform";
		}
		boolean subPass = false;
		List<Enroll> en = enrollService.enrollAllList(prof.getNo());
		// 동일한 과목을 다시 등록하는지 체크
		for(Enroll e : en){ 
			if(e.getSubject().getNo()==enrollform.getSubjectNo()){
				subPass = true;
				model.addAttribute("subPass", subPass);
				System.out.println("동일한 과목번호가 존재한다."+enrollform.getSubjectNo());
				return "redirect:/prof/addenrollform";
			}
			
		}
		boolean dayPass = false;
		// 겹치는 시간이 존재하는지 체크
		String newEnrollTimes = enrollform.getEnrollTime().replaceAll(",", "");
		for(Enroll e : en){
			if (e.getEnrollDay().equals(enrollform.getEnrollDay())) {
				String enrollTimes = e.getEnrollTime();
				if (enrollTimes.matches(".*["+newEnrollTimes+"].*")) {
					dayPass = true;
					model.addAttribute("dayPass",dayPass);
					System.out.println("중복값발생 ["+newEnrollTimes+"] ["+enrollTimes+"]");
					return "redirect:/prof/addenrollform";
				}
				
			}
		}
		
		/*for(Enroll e : en){
			String ee[] = e.getEnrollTime().split(",");
			String rr[] = enrollform.getEnrollTime().split(",");
			if(e.getEnrollDay().equals(enrollform.getEnrollDay())){
				for(int i=0; i<ee.length; i++){
					for(int j=0; j<rr.length; i++){
						if(ee[i].equals(rr[j])){
							System.out.println("중복값발생"+ee+rr);
							return "redirect:/prof/addenrollform";
						}
					}
				}
			}
			
		}
*/
		Enroll enroll = new Enroll();
		Subject subject = new Subject();
		subject.setNo(enrollform.getSubjectNo());
		enroll.setSubject(subject);
		BeanUtils.copyProperties(enrollform, enroll);
		enrollService.addEnroll(enroll);
		
		
		return "redirect:/prof/subinfo";
	}
	
	@RequestMapping("/timeschedule")
	public String timeschedule(){
		return "/prof/timeschedule";
	}
	
	@RequestMapping("/subinfo")
	public String subinfo(Model model, HttpSession session){
		Professor prof = (Professor) session.getAttribute("LOGIN_USER");
		System.out.println(prof.getId());
		List<Enroll> subList = enrollService.getProfEnroll(prof.getId());
		model.addAttribute("subList", subList);
		
		return "/prof/subinfo";
	}
	@RequestMapping("/subdel")
	public String deleteSub(@RequestParam("no") int no){
		System.out.println(no);
		enrollService.deleteEnroll(no);
		
		
		return "redirect:/prof/subinfo";
	}
	@RequestMapping("/subdetail")
	public String subdetail(@RequestParam("no")int no, Model model, Subject sub){
		
		Subject subno = subjectService.getByENoList(no);
		model.addAttribute("subno", subno);
		return "/prof/subdetail";
	}
	@RequestMapping(value="/subupdate", method=RequestMethod.GET)
	public String subupdateform(@RequestParam("no")int no, Model model, @Valid @ModelAttribute("enrollform")EnrollForm enrollform, HttpSession session){
		Enroll enroll = enrollService.getEnrollByENoService(no);
		int sele = enroll.getSubject().getNo(); //170
		System.out.println(sele);
		model.addAttribute("enroll", enroll);
		model.addAttribute("sele", sele);
		Professor prof = (Professor) session.getAttribute("LOGIN_USER");
		List<Subject> subList = subjectService.getByProIdList(prof.getId());
		model.addAttribute("subList", subList);
		
		return "/prof/subupdate";
	}
	@RequestMapping(value="/subupdate", method=RequestMethod.POST)
	public String subupdate(@RequestParam("no") int no,@Valid @ModelAttribute("enrollform")EnrollForm enrollform, Errors errors) throws Exception{
		System.out.println(enrollform);
		if(errors.hasErrors()){
			System.out.println(errors.getAllErrors());
			return "/prof/subupdate";
		}
		Subject subject = new Subject();
		Enroll enroll = new Enroll();
		enroll.setNo(no);
		subject.setNo(enrollform.getSubjectNo());
		enroll.setSubject(subject);
		BeanUtils.copyProperties(enrollform, enroll);
		enrollService.updateEnroll(enroll);
		return "redirect:/prof/subinfo";
	}
	@RequestMapping(value="/profinfo", method=RequestMethod.GET)
	public String profinfo(@Valid @ModelAttribute("professorForm")ProfessorForm professorForm,Model model, HttpSession session){
		Professor prof = (Professor) session.getAttribute("LOGIN_USER");
		Professor prof1 = professorService.getProfessorById(prof.getId());
		System.out.println("prof 찍기 전 db작업전");
		System.out.println(prof1);
		model.addAttribute("prof", prof1);
		return "/prof/profInfo";
	}
	
	@RequestMapping(value="/profinfo", method=RequestMethod.POST)
	public String profinfoform(@Valid @ModelAttribute("professorForm")ProfessorForm professorForm,
						BindingResult errors, Professor professor, Model model)throws Exception{
		if(errors.hasErrors()){
			model.addAttribute("prof",professor);
			return "/prof/profInfo";
		}
		System.out.println(professorForm);
		System.out.println(professor);
		model.addAttribute("professorForm", professorForm);
		BeanUtils.copyProperties(professorForm, professor);		
		professorService.updateProfessorInfo(professor);
		
		
		return "redirect:/prof/profinfo";
	}
	@RequestMapping(value="/profPwdCheck", method=RequestMethod.GET)
	public String profPwdCheckForm(){
		
		return "/prof/profpwdcheck";
	}
	@RequestMapping(value="/profPwdCheck", method=RequestMethod.POST)
	public String profPwdCheck(Professor professor, Model model, HttpSession session,
					@RequestParam(value="profPwd", required=true)String profPwd,
					@RequestParam(value="Repwd", required=true)String Repwd){
		boolean isPassed = false;
		Professor prof = (Professor) session.getAttribute("LOGIN_USER");
		System.out.println(prof);
		System.out.println(professor);
		System.out.println(profPwd);
		if(profPwd.equals(prof.getPwd())){
			System.out.println(profPwd + "." +professor);
			isPassed = true;
			professor.setPwd(Repwd);
			professorService.updateProfessorPwd(professor);
			model.addAttribute("confirm", isPassed);
			model.addAttribute("professor",professor);
			return "/prof/profpwdcheck";
		}
		return "redirect:/prof/profPwdCheck";
	}
	
	

}
