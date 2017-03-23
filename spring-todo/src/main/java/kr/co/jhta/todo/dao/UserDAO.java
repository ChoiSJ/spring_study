package kr.co.jhta.todo.dao;

import kr.co.jhta.todo.vo.User;

public interface UserDAO {
	
	void addUser(User user);
	User getUserById(String id);
	void increaseUncompletedTodoAmount(int userno);
	void decreaseUncompletedTodoAmount(int userno);
	void increaseCompletedTodoAmount(int userno);
	void decreaseCompletedTodoAmount(int userno);
}
