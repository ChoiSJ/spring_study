package kr.co.jhta.controller.major;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.service.major.SemesterService;
import kr.co.jhta.vo.Semester;
import kr.co.jhta.vo.SemesterForm;

@Controller
public class SemesterController {

	@Autowired
	private SemesterService semesterService;
	
	@RequestMapping("/semester")
	public String semesterMain(Model model) {
		
		List<Semester> semesterList = semesterService.getAllSemester();
		
		model.addAttribute("semesterList", semesterList);
		
		return "major/semesterList";
	}
	
	@RequestMapping(value="/addSemester", method=RequestMethod.GET)
	public String semeform() {
		return "major/semeRegister";
	}
	
	@RequestMapping(value="/addSemester", method=RequestMethod.POST)
	public String semeregister(SemesterForm semeform, String selectyear,String selectseme ) throws Exception{
		String semeSelect = selectyear;
		semeSelect = semeSelect+ "-"+selectseme;
		semeform.setSemeSelect(semeSelect);
		Semester semester = new Semester();
		
		BeanUtilsBean beanUtilsBean = BeanUtilsBean.getInstance();
		beanUtilsBean.getConvertUtils().register(new org.apache.commons.beanutils.converters.SqlTimestampConverter(null), java.sql.Timestamp.class);
		
		BeanUtils.copyProperties(semeform, semester);
		semesterService.addSemester(semester);
		
		return "redirect:/semester";
	}
	
	@RequestMapping(value="/detailSeme")
	public String detailSeme(@RequestParam("no") int no, Model model){
		
		Semester semester = semesterService.getSemesterByNo(no);
		model.addAttribute("semeupdateform", semester);
		return "major/semedetail"; 
	}
	
	@RequestMapping(value="/editseme", method=RequestMethod.POST )
	public String editSeme(SemesterForm semeform, String selectyear, String selectseme) throws Exception {
		
		String semeSelect = selectyear;
		semeSelect = semeSelect+ "-"+selectseme;
		semeform.setSemeSelect(semeSelect);
		
		Semester semester = new Semester();
		
		BeanUtilsBean beanUtilsBean = BeanUtilsBean.getInstance();
		beanUtilsBean.getConvertUtils().register(new org.apache.commons.beanutils.converters.SqlTimestampConverter(null), java.sql.Timestamp.class);
		BeanUtils.copyProperties(semeform, semester);
		
		
		semesterService.editSemesterByNo(semester);
		
		
		return "redirect:/semester";
	}
	
	
}
