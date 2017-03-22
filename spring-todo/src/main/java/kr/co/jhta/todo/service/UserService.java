package kr.co.jhta.todo.service;

import kr.co.jhta.todo.vo.User;

public interface UserService {
	
	void registerUser(User user);
	User getLoginUserInfo(String id, String pwd);
}
