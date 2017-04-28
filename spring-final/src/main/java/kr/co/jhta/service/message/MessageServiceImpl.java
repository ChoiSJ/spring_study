package kr.co.jhta.service.message;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.message.MessageDao;
import kr.co.jhta.vo.Message;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.stu.Student;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageDao messageDao;
	
	@Override
	public List<Student> getAddressByStuName(String searchWord) {
		return messageDao.getAddressByStuName(searchWord);
	}
	
	@Override
	public List<Professor> getAddressByProName(String searchWord) {
		return messageDao.getAddressByProName(searchWord);
	}
	
	@Override
	public void addMessage(Message message) {
		messageDao.addMessage(message);
	}
	
	@Override
	public List<Message> getReceiveMessageAdmin(String id) {
		return messageDao.getReceiveMessageAdmin(id);
	}
	
	@Override
	public void deleteSendMessage(int dno) {
		messageDao.deleteSendMessage(dno);
	}
	
	@Override
	public void deleteReceiveMessage(int dno) {
		messageDao.deleteReceiveMessage(dno);
	}
	
	@Override
	public List<SiteMap> getDivisionByName(String searchWord) {
		return messageDao.getDivisionByName(searchWord);
	}
	
	@Override
	public List<Student> getStudentByCode(String code) {
		return messageDao.getStudentByCode(code);
	}
	
	@Override
	public List<Subject> getSubjectByName(String searchWord) {
		return messageDao.getSubjectByName(searchWord);
	}
	
	@Override
	public List<Map<String, Object>> getStudentByNo(String subjectNo) {
		return messageDao.getStudentByNo(subjectNo);
	}
	
	@Override
	public String getFilenameByNo(int messageNo) {
		return messageDao.getFilenameByNo(messageNo);
	}
	
	@Override
	public List<Message> getSendMessageAdmin(String id) {
		return messageDao.getSendMessageAdmin(id);
	}
	
	@Override
	public void addMessageCheck(int messageNo) {
		messageDao.addMessageCheck(messageNo);
	}
}
