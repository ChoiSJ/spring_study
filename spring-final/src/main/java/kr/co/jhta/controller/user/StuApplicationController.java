package kr.co.jhta.controller.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.service.appli.DropoffService;
import kr.co.jhta.service.appli.LeaveService;
import kr.co.jhta.service.appli.ReinstatementService;
import kr.co.jhta.service.hakjuk.HakjukService;
import kr.co.jhta.service.user.StudentService;
import kr.co.jhta.vo.appli.Leave;
import kr.co.jhta.vo.appli.LeaveForm;
import kr.co.jhta.vo.hakjuk.Dropoff;
import kr.co.jhta.vo.stu.Student;

@Controller
@RequestMapping("/stud")
public class StuApplicationController {

	@Autowired
	StudentService stuService;
	
	@Autowired
	ReinstatementService reinService;
	
	@Autowired
	LeaveService leaveService;
	
	@Autowired
	DropoffService dropoffService;
	
	@Autowired
	HakjukService hakjukService;
	
	@RequestMapping(value="enrollCancel", method=RequestMethod.GET)
	public String leaveCancel(@RequestParam("lNo") int lNo, Model model, Student student) {
		
		leaveService.deleteEnrollByNoService(lNo, student.getNo());
		return "redirect:/stud/leave";
	}
	
	@RequestMapping(value="/enrollLeave", method=RequestMethod.POST)
	public String leaveEnroll(Model model, Student student, LeaveForm leaveForm){
		
		Leave leave = new Leave();
		if(leaveForm.getCheckboxTrue().equals("true")) {
			leaveService.updateLeaveService(leaveForm.getReEno(), student.getNo(), leaveForm.getChageReason());
			return "redirect:/stud/leave";
			
		}  else {
			leave.setCode(leaveForm.getcCode());
			leave.setStuNo(student.getNo());
			if(leaveForm.getScorePass().equals("true")) {
				leave.setScorePass("true");
			} else {
				leave.setScorePass("false");
			}			
			Long beforedParsedDate = Long.parseLong(leaveForm.getReinDate());
			Date date = new Date(beforedParsedDate);
			leave.setReinDate(date);
			leaveService.addNewLeaveService(leave);
			/*selectSemeter:2 update 추가하기 (student remainleave - 하기)*/
		}
		return "redirect:/stud/leave";
	}	
	
	@RequestMapping(value="/reinstate", method=RequestMethod.POST)
	public String setReinstateProcess(int leaveNo,Student student){
		System.out.println("휴학 번호 :"+leaveNo);
		Leave leave = hakjukService.getLeaveByNoService(leaveNo);		
		reinService.addNewReinByLeave(leave);
		return "redirect:/stud/home";
	}
	@RequestMapping(value="/dropoff", method=RequestMethod.POST)
	public String dropoffPost(Dropoff drop,Student student) throws Exception{
		drop.setNo(student.getNo());
		dropoffService.addNewDropoffService(drop);
		return "redirect:/stud/home";
	}

}
