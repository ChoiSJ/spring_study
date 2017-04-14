package kr.co.jhta.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.jhta.service.major.SubjectService;
import kr.co.jhta.service.professor.ProfessorService;
import kr.co.jhta.service.professor.SyllabusService;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.Syllabus;
import kr.co.jhta.vo.Syllabusform;

@Controller
public class ProfController {
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private SyllabusService syllabusService;
	
	@RequestMapping("/profMain")
	public String testMain() {
		return "/prof/profMain";
	}
	
	@RequestMapping("/syllabus")
	public String syllAbus(Model model){
		
		return "/prof/syllabus";
	}
	@RequestMapping(value="/syllform", method=RequestMethod.GET)
	public String syllForm(Model model){
		List<Professor> proList = professorService.proAllList();
		model.addAttribute("proList", proList);
		List<Subject> subList = subjectService.getAllList();
		model.addAttribute("subList", subList);
		model.addAttribute("syllabusform", new Syllabusform());
		
		return "/prof/syllabusform";
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
		return "redirect:/syllinfo";
	}
	@RequestMapping("/syllinfo")
	public String syllInfo(Model model){
		List<Syllabus> syllList = syllabusService.getAllList();
		model.addAttribute("syllList", syllList);
		return "/prof/syllabusInfo";
	}
	
	
}
