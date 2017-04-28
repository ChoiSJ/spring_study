package kr.co.jhta.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.jhta.controller.view.FiledownloadView;
import kr.co.jhta.service.message.MessageService;
import kr.co.jhta.vo.Message;
import kr.co.jhta.vo.MessageForm;
import kr.co.jhta.vo.PageNation;
import kr.co.jhta.vo.stu.Student;

@Controller
public class StuMessageController {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private FiledownloadView fileView;
	
	String directory = "C:\\spring_project\\final_upload";
	
	@RequestMapping("/stud/stumessageform")
	public String proMessageForm(Model model) {
		model.addAttribute("messageForm", new MessageForm());
		return "message/stumessageform";
	}
	
	@RequestMapping("/stud/stusendmessagebox")
	public String proSendEmailBox(Model model, Student stud, @RequestParam(name="pno", defaultValue="1") int pno) {
		List<Message> messageAllList = messageService.getSendMessageAdmin(stud.getId());
		
		int totalRows = messageAllList.size();
		PageNation pagination = new PageNation(10, pno, totalRows);
		model.addAttribute("pagination", pagination);
		List<Message> messageList = new ArrayList<Message>();
		
		for (int i=pagination.getBeginIndex()-1; i<pagination.getEndIndex(); i++) {
			messageList.add(messageAllList.get(i));
		}
		
		model.addAttribute("messageList", messageList);
		
		return "message/stusendmessagebox";
	}
	
	@RequestMapping("/stud/sturecmessagebox")
	public String proRecieveEmailBox(Model model, Student stud, @RequestParam(name="pno", defaultValue="1") int pno) {
		List<Message> messageAllList = messageService.getReceiveMessageAdmin(stud.getId());
		System.out.println(stud.getId());
		int totalRows = messageAllList.size();
		PageNation pagination = new PageNation(10, pno, totalRows);
		model.addAttribute("pagination", pagination);
		List<Message> messageList = new ArrayList<Message>();
		
		for (int i=pagination.getBeginIndex()-1; i<pagination.getEndIndex(); i++) {
			messageList.add(messageAllList.get(i));
		}
		
		model.addAttribute("messageList", messageList);
		
		return "message/sturecmessagebox";
	}
	
	@RequestMapping(value="/stud/sendmessage", method=RequestMethod.POST)
	public String sendMessage(@ModelAttribute(name="messageForm") MessageForm messageForm, Student stud, String option) throws IllegalAccessException, InvocationTargetException, FileNotFoundException, IOException {
		String[] receiverList;
		
		// 보내는 사람이 여러 명일 경우와, 한 명을 경우를 나누는 코드
		if (messageForm.getReceiver().contains(",")) {
			receiverList = messageForm.getReceiver().split(",");
		} else {
			receiverList = new String[1];
			receiverList[0] = messageForm.getReceiver();
		}
		
		MultipartFile file = messageForm.getFile();
		
		if (option.equals("name")) {
			for (String receiver : receiverList) {
				Message message = new Message();
				BeanUtils.copyProperties(message, messageForm);
				message.setWriter(stud.getId());
				message.setWriterName(stud.getName());
				message.setReceiver(receiver);
				
				if (!file.isEmpty()) {
					IOUtils.copy(file.getInputStream(), new FileOutputStream(new File(directory, file.getOriginalFilename())));
					message.setFilename(file.getOriginalFilename());
				} 
				
				messageService.addMessage(message);
			}			
		} else if (option.equals("division")) {
			for (String receiver : receiverList) {
				List<Student> stuList = messageService.getStudentByCode(receiver);
				
				for (Student stu : stuList) {
					Message message = new Message();
					BeanUtils.copyProperties(message, messageForm);
					message.setWriter(stud.getId());
					message.setWriterName(stud.getName());
					message.setReceiver(stu.getId());
					
					if (!file.isEmpty()) {
						IOUtils.copy(file.getInputStream(), new FileOutputStream(new File(directory, file.getOriginalFilename())));
						message.setFilename(file.getOriginalFilename());
					}
					
					messageService.addMessage(message);
				}
			}
		} else if (option.equals("subject")) {
			for (String receiver : receiverList) {
				List<Map<String, Object>> stuList = messageService.getStudentByNo(receiver);
				
				for (Map<String, Object> stu : stuList) {
					Message message = new Message();
					BeanUtils.copyProperties(message, messageForm);
					message.setWriter(stud.getId());
					message.setWriterName(stud.getName());
					message.setReceiver((String) stu.get("STUID"));
					
					if (!file.isEmpty()) {
						IOUtils.copy(file.getInputStream(), new FileOutputStream(new File(directory, file.getOriginalFilename())));
						message.setFilename(file.getOriginalFilename());
					}
					
					messageService.addMessage(message);
				}
			}
		}
		
		return "redirect:/stud/sturecmessagebox";
	}
	
	@RequestMapping(value="/stud/deletesendmessage")
	public String deleteSendMessage(Integer[] dnoList) {
		for (int dno : dnoList) {
			messageService.deleteSendMessage(dno);
		}
		
		return "redirect:/stud/stusendmessagebox";
	}
	
	@RequestMapping(value="/stud/deletereceivemessage")
	public String deleteReceiveMessage(Integer[] dnoList) {
		for (int dno : dnoList) {
			messageService.deleteReceiveMessage(dno);
		}
		
		return "redirect:/stud/sturecmessagebox";
	}
	
	@RequestMapping("/stud/stusearch")
	public @ResponseBody List<?> proAddressSearch(String checkedRadio, String searchWord, String searchOption) {
		List<?> resultList = new ArrayList<Object>();
		
		if (searchOption.equals("name")) {
			if (checkedRadio.equals("stu")) {
				resultList = messageService.getAddressByStuName(searchWord);
			} else if (checkedRadio.equals("pro")) {
				resultList = messageService.getAddressByProName(searchWord);
			}
		} else if (searchOption.equals("division")) {
			resultList = messageService.getDivisionByName(searchWord);
		} else if (searchOption.equals("subject")) {
			resultList = messageService.getSubjectByName(searchWord);
		}
		
		return resultList;
	}
	
	@RequestMapping("/stud/messagedownload")
	public ModelAndView messageDownload(@RequestParam("no") int no) {
		String filename = messageService.getFilenameByNo(no);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("directory", directory);
		mav.addObject("filename", filename);
		mav.setView(fileView);
		
		return mav;
	}
	
	@RequestMapping(value="/stud/addmessagecheck", produces="application/json; charset=UTF-8")
	public @ResponseBody String addMessageCheck(int messageNo) {
		messageService.addMessageCheck(messageNo);
		
		return "{\"success\": \"성공\"}";
	}
}
