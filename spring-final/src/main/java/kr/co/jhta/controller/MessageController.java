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
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.stu.Student;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private FiledownloadView fileView;
	
	String directory = "C:\\spring_project\\final_upload";
	
	@RequestMapping("/admin/adminmessageform")
	public String adminMessageForm(Model model) {
		model.addAttribute("messageForm", new MessageForm());
		return "administer/adminmessageform";
	}
	
	@RequestMapping("/admin/adminsendmessagebox")
	public String adminSendEmailBox(Model model, Professor prof, @RequestParam(name="pno", defaultValue="1") int pno) {
		List<Message> messageAllList = messageService.getSendMessageAdmin(prof.getId());
		
		int totalRows = messageAllList.size();
		PageNation pagination = new PageNation(10, pno, totalRows);
		model.addAttribute("pagination", pagination);
		List<Message> messageList = new ArrayList<Message>();
		
		for (int i=pagination.getBeginIndex()-1; i<pagination.getEndIndex(); i++) {
			messageList.add(messageAllList.get(i));
		}
		
		model.addAttribute("messageList", messageList);
		
		return "administer/adminsendmessagebox";
	}
	
	@RequestMapping("/admin/adminrecmessagebox")
	public String adminRecieveEmailBox(Model model, Professor prof, @RequestParam(name="pno", defaultValue="1") int pno) {
		List<Message> messageAllList = messageService.getReceiveMessageAdmin(prof.getId());
		
		int totalRows = messageAllList.size();
		PageNation pagination = new PageNation(10, pno, totalRows);
		model.addAttribute("pagination", pagination);
		List<Message> messageList = new ArrayList<Message>();
		
		for (int i=pagination.getBeginIndex()-1; i<pagination.getEndIndex(); i++) {
			messageList.add(messageAllList.get(i));
		}
		
		model.addAttribute("messageList", messageList);
		
		return "administer/adminrecmessagebox";
	}
	
	@RequestMapping(value="/admin/sendmessage", method=RequestMethod.POST)
	public String sendMessage(@ModelAttribute(name="messageForm") MessageForm messageForm, Professor prof, String option) throws IllegalAccessException, InvocationTargetException, FileNotFoundException, IOException {
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
				message.setWriter(prof.getId());
				message.setWriterName(prof.getName());
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
					message.setWriter(prof.getId());
					message.setWriterName(prof.getName());
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
					message.setWriter(prof.getId());
					message.setWriterName(prof.getName());
					message.setReceiver((String) stu.get("STUID"));
					
					if (!file.isEmpty()) {
						IOUtils.copy(file.getInputStream(), new FileOutputStream(new File(directory, file.getOriginalFilename())));
						message.setFilename(file.getOriginalFilename());
					}
					
					messageService.addMessage(message);
				}
			}
		}
		
		return "redirect:/admin/adminrecmessagebox";
	}
	
	@RequestMapping(value="/admin/deletesendmessage")
	public String deleteSendMessage(Integer[] dnoList) {
		for (int dno : dnoList) {
			messageService.deleteSendMessage(dno);
		}
		
		return "redirect:/adminsendmessagebox";
	}
	
	@RequestMapping(value="/admin/deletereceivemessage")
	public String deleteReceiveMessage(Integer[] dnoList) {
		for (int dno : dnoList) {
			messageService.deleteReceiveMessage(dno);
		}
		
		return "redirect:/admin/adminrecmessagebox";
	}
	
	@RequestMapping("/admin/adminsearch")
	public @ResponseBody List<?> adminAddressSearch(String checkedRadio, String searchWord, String searchOption) {
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
	
	@RequestMapping("/admin/messagedownload")
	public ModelAndView messageDownload(@RequestParam("no") int no) {
		String filename = messageService.getFilenameByNo(no);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("directory", directory);
		mav.addObject("filename", filename);
		mav.setView(fileView);
		
		return mav;
	}
	
	@RequestMapping(value="/admin/addmessagecheck", produces="application/json; charset=UTF-8")
	public @ResponseBody String addMessageCheck(int messageNo) {
		messageService.addMessageCheck(messageNo);
		
		return "{\"success\": \"성공\"}";
	}
}
