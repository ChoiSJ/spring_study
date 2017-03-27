package kr.co.jhta.rest.service;

import java.util.List;

import kr.co.jhta.rest.vo.User;

public interface UserService {
	
	List<User> getAllUsers();
	User getUserByNo(int no);
	User saveUser(User user);
}
