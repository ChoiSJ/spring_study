package kr.co.jhta.service.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.message.MessageDao;
import kr.co.jhta.vo.Professor;
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
}
