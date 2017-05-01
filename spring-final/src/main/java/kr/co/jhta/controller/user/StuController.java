package kr.co.jhta.controller.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.service.board.BoardService;
import kr.co.jhta.service.sitemap.SitemapService;
import kr.co.jhta.service.user.RegisubjectService;
import kr.co.jhta.service.user.StudentService;
import kr.co.jhta.vo.Board;
import kr.co.jhta.vo.SearchForm;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.stu.Regisubject;
import kr.co.jhta.vo.stu.Student;
import kr.co.jhta.vo.stu.StudentForm;

@Controller
@RequestMapping("/stud")
public class StuController {
	
	@Autowired
	private StudentService stuService;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private SitemapService sitemapService;
	
	@Autowired
	private RegisubjectService regisubjectService;
	
	@RequestMapping("/home")
	public String stuMain(Student student, Model model, SearchForm searchForm) {
		
		final String BOARDTYPE = "N";
		
		List<Board> boardList = boardService.searchNoticeBoardByCount(BOARDTYPE);
		model.addAttribute("boardList", boardList);
		
		SiteMap siteMap = sitemapService.getSitemapByCodeService(student.getDivision());
		searchForm.setDepartment(siteMap.getName());
		searchForm.setSearchBoardType("D");
		List<Board> deptList = boardService.searchDeptBoardByCount(searchForm);
		
		model.addAttribute("deptList", deptList);
				
		// 현재 수강 과목 표시
		List<Regisubject> regisubList = regisubjectService.getRegisByUserNoService(student.getNo());
		if(!regisubList.isEmpty()) {
			model.addAttribute("regisubList", regisubList);
		}
		
		return "/student/stuMain";
	}

	@RequestMapping(value="/stuInfo", method=RequestMethod.GET)
	public String stuInfo(Model model, Student student) {
		student = stuService.getStudentById(student.getId());
		String tName = stuService.getTnameByTcodeService(student.getNo(), student.getDivision());
	    String cName = stuService.getCnameByRegisterService(student.getRegister());
	    student.setcName(cName);
	    student.settName(tName);
		model.addAttribute("student", student);
		StudentForm studentForm = new StudentForm();
		BeanUtils.copyProperties(student, studentForm);
		model.addAttribute("studentForm", studentForm);
		// 과목 이름으로 출력을 위해 service사용
		return "/student/stuInfo/stuInfo";
	}
	
	
	@RequestMapping(value="/stuInfo", method=RequestMethod.POST)
	public String stuPhoneEdit(@Valid @ModelAttribute("studentForm") StudentForm studentForm, 
					BindingResult errors, Model model, Student student) throws Exception{
		if(errors.hasErrors()) {
			return "/student/stuInfo/stuInfo";
		}
		System.out.println(studentForm);
		Student updateStudent = new Student();
		BeanUtils.copyProperties(studentForm, updateStudent);
		stuService.updateStudentInfoService(updateStudent);
		return "redirect:/stud/stuInfo";
	}
		
	
	@RequestMapping(value="/stuPwdCheck", method=RequestMethod.GET)
	public String stuPwdCheckForm() {
		return "/student/stuInfo/stuPwdCheck";
	}
	
	@RequestMapping(value="/stuPwdCheck", method=RequestMethod.POST) 
	public String stuPwdCheck(Student student, Model model, 
						@RequestParam(value="stuPwd", required=true) String stuPwd,
						@RequestParam(value="Repwd", required=true) String Repwd) {
		boolean isPassed = false;
		if(student.getPwd().equals(stuPwd)) {
			isPassed = true;
			student.setPwd(Repwd);
			stuService.updateStudentPwdService(student);
			model.addAttribute("student", student);
			model.addAttribute("confirm", isPassed);
			return "/student/stuInfo/stuPwdCheck";
		}		
		model.addAttribute("confirm", isPassed);
		return "/student/stuInfo/stuPwdCheck";
	}
	
	@RequestMapping(value="/stuPwdEdit", method=RequestMethod.GET)
	public String stuPwdEditForm() {
		return "/student/stuInfo/stuPwdEdit";
	}
	
	@RequestMapping(value="/stuPwdEdit", method=RequestMethod.POST)
	public String stuPwdEditProcess() {
		
		return null;
	}
}
