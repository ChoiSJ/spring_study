package kr.co.jhta.dao.message;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.vo.Message;
import kr.co.jhta.vo.Professor;
import kr.co.jhta.vo.SiteMap;
import kr.co.jhta.vo.Subject;
import kr.co.jhta.vo.stu.Student;

@Transactional
public interface MessageDao {
	
	List<Student> getAddressByStuName(String name);
	List<Professor> getAddressByProName(String name);
	void addMessage(Message message);
	List<Message> getReceiveMessageAdmin(String id);
	List<Message> getSendMessageAdmin(String id);
	void deleteSendMessage(int dno);
	void deleteReceiveMessage(int dno);
	List<SiteMap> getDivisionByName(String name);
	List<Student> getStudentByCode(String code);
	List<Subject> getSubjectByName(String name);
	List<Map<String, Object>> getStudentByNo(String sno);
	String getFilenameByNo(int no);
	void addMessageCheck(int no);
}
