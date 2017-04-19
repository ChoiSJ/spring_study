package kr.co.jhta.controller.user;

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

import kr.co.jhta.service.user.StudentService;
import kr.co.jhta.vo.stu.Student;
import kr.co.jhta.vo.stu.StudentForm;

@Controller
@RequestMapping("/stud")
public class StuController {
	
	@Autowired
	StudentService stuService;
	
	@RequestMapping("/home")
	public String stuMain() {
		return "/student/stuMain";
	}
	
	@RequestMapping(value="/stuInfo", method=RequestMethod.GET)
	public String stuInfo(Model model, Student student) {
		if(student.getName() == null) {
			return "redirect:/login?err=deny";
		}
		model.addAttribute("student", student);
		StudentForm studentForm = new StudentForm();
		BeanUtils.copyProperties(student, studentForm);
		model.addAttribute("studentForm", studentForm);
		
		// 과목 이름으로 출력을 위해 service사용
		String tName = stuService.getTnameByTcodeService(student.getDivision());
		model.addAttribute("tName", tName);
		return "/student/stuInfo/stuInfo";
	}
	
	@RequestMapping(value="/stuInfo", method=RequestMethod.POST)
	public String stuPhoneEdit(@Valid @ModelAttribute("studentForm") StudentForm studentForm, 
					BindingResult errors, Student student, Model model) throws Exception{
		if(errors.hasErrors()) {
			model.addAttribute("student", student);
			return "/student/stuInfo/stuInfo";
		}
		model.addAttribute("studentForm", studentForm);
		BeanUtils.copyProperties(studentForm, student);
		stuService.updateStudentInfoService(student);
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
			stuService.updateStudentPwdService(student);
			model.addAttribute("student", student);
			return "/student/stuInfo/stuPwdEdit";
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
