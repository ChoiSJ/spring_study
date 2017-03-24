package example.mybatis;

import java.util.List;

import kr.co.jhta.todo.vo.User;

public interface UserMapper {
	
	void addUser(User user);
	List<User> getAllUsers();
	User getUserById(String id);
}
