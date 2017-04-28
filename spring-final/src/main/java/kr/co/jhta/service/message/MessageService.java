package kr.co.jhta.service.message;

import java.util.List;
import java.util.Map;

import kr.co.jhta.vo.Message;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.stu.Student;

public interface MessageService {
	
	List<Student> getAddressByStuName(String searchWord);
	List<Professor> getAddressByProName(String searchWord);
	void addMessage(Message message);
	List<Message> getReceiveMessageAdmin(String id);
	List<Message> getSendMessageAdmin(String id);
	void deleteSendMessage(int dno);
	void deleteReceiveMessage(int dno);
	List<SiteMap> getDivisionByName(String searchWord);
	List<Student> getStudentByCode(String code);
	List<Subject> getSubjectByName(String searchWord);
	List<Map<String, Object>> getStudentByNo(String subjectNo);
	String getFilenameByNo(int messageNo);
	void addMessageCheck(int messageNo);
}
