package kr.co.jhta.controller.enrollAjax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import kr.co.jhta.service.user.EnrollService;
import kr.co.jhta.vo.stu.Enroll;

@RestController
public class AjaxStuEnrollController {
	
	@Autowired
	MappingJackson2JsonView jsonView;
	
	@Autowired
	EnrollService enrollService;
	
	// 현재 사용안함
	@RequestMapping("/enrollMain/{no}")
	public @ResponseBody Enroll enrollSubject(@PathVariable("no") int no) {
		Enroll enroll = enrollService.getEnrollByENoService(no);
//		enrollService.addRegisubService(enroll);
		System.out.println(enroll.getNo());
		return enroll;
	}
	
}