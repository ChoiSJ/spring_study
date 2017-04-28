package kr.co.jhta.controller.user;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.jhta.service.appli.LeaveService;
import kr.co.jhta.service.user.StudentService;
import kr.co.jhta.vo.appli.Leave;
import kr.co.jhta.vo.stu.Student;

@Controller
@RequestMapping("/stud")
public class StuApplicationFormController {
	
	@Autowired
	StudentService stuService;
	
	@Autowired
	LeaveService leaveService;
	
		
	static String ccName = "";
	
	@RequestMapping(value="/leave", method=RequestMethod.GET)
	public String stuLeave(Model model, Student student, HttpServletResponse response) throws Exception {
		// 기본 정보 담기
		System.out.println(student);
		Student stud = stuService.getStudentALLByIdService(student.getId());
		System.out.println(stud);
		if(!(stud.getRegister().equals("AD3000"))){ // 휴학자가 아니거나 재학생이 아닐경우 휴학신청 란에 들어오지 못한다.
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
            out.println("<script>alert('휴학을 신청하실수 없습니다.'); history.go(-1);</script>");
            out.flush();
		}
		model.addAttribute("student", stud);		
		// 휴학 정보 담기
		
		List<Leave> leaveList = leaveService.getAllEnrolledLeaveByStuNoService(student.getNo());
		
		for(Leave leave : leaveList ) {
			ccName = leaveService.getCnameByCcodeService(leave.getCode());
			leave.setcName(ccName);
		}
		model.addAttribute("leaveList", leaveList);
		return "/student/applications/leaveForm";
	}
		
	@RequestMapping(value="/reinstate", method=RequestMethod.GET)
	public String setReinstate(Model model, Student student, HttpServletResponse response) throws Exception{
		
		// 기본 정보 담기
		Student stud = stuService.getStudentALLByIdService(student.getId());
		if(!(stud.getRegister().substring(0,2).equals("LV"))){ // 휴학자가 아니거나 재학생이 아닐경우 휴학신청 란에 들어오지 못한다.
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
            out.println("<script>alert('복학을 신청하실수 없습니다.'); history.go(-1);</script>");
            out.flush();
		}
		model.addAttribute("leaveList",leaveService.getLeaveOneBystuNoService(stud.getNo()));
		model.addAttribute("student", stud);
		return "/student/applications/ReinstatementForm";
	}
	
	@RequestMapping(value="/dropoff", method=RequestMethod.GET)
	public String dropoff(Model model, Student student) throws Exception{
		
		// 기본 정보 담기
		Student stud = stuService.getStudentALLByIdService(student.getId());
		model.addAttribute("student", stud);
		
		return "/student/applications/dropoffForm";
	}
	
	// 학적상태를 학생 번호와 C코드를 받아 반환한다.
	public String getTnameInController(Student student) {
		String tName = stuService.getTnameByTcodeService(student.getNo(), student.getDivision());
		return tName;
	}
}
