package kr.co.jhta.controller.hakjuk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.service.hakjuk.JejukService;
import kr.co.jhta.vo.JejukStuSearchForm;
import kr.co.jhta.vo.SubjectSearchForm;
import kr.co.jhta.vo.hakjuk.JejukList;
import kr.co.jhta.vo.hakjuk.StudentJejuk;
import kr.co.jhta.vo.stu.Student;

@Controller
@RequestMapping("/admin")
public class JejukController {

	@Autowired
	private JejukService jejukService;
	
	@RequestMapping("/jejukmain")
	public String jejukMain() {
		return "collegeregister/adminjejukmain";
	}
	
	// 학생 검색 결과
	@RequestMapping("/searchstubyopt")
	public String searchStuByOpt(JejukStuSearchForm searchForm, Model model) {
		List<Student> stuList = jejukService.searchByOpt(searchForm);
		model.addAttribute("resultList", stuList);
		return "collegeregister/adminjejukmain";
	}
	
	// 검색 결과에서 선택한 학생 제적 처리페이지로
	@RequestMapping("/registerjejuk")
	public String registerJejuk(@RequestParam("sno") int sno, Model model) {
		Student student = jejukService.getDetailStuForJejuk(sno);
		model.addAttribute("student", student);
		return "collegeregister/registerjejuk";
	}
	
	// 제적 처리
	@RequestMapping("/insurejejuk")
	public String insureJejuk(StudentJejuk jejuk) {
		jejukService.registjejuk(jejuk);
		int no = jejuk.getStudent().getNo();
		jejukService.studentjejuk(no);
		return "redirect:/admin/jejuklist";
	}
	
	// 처리 리스트
	@RequestMapping("/jejuklist")
	public String getlistjejuk (Model model) {
		List<JejukList> jejukList  = jejukService.getStudentJejuk();
		model.addAttribute("jejukList", jejukList);
		return "collegeregister/jejuklist";
	}
}
