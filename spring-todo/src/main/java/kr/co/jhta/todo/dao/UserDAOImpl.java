package kr.co.jhta.todo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.jhta.todo.vo.User;

@SuppressWarnings("deprecation")
@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlMapClientTemplate template;
	
	@Override
	public void addUser(User user) {
		template.insert("user.addUser", user);
	}
	
	@Override
	public User getUserById(String id) {
		return (User) template.queryForObject("user.getUserById", id);
	}

	@Override
	public void increaseUncompletedTodoAmount(int userno) {
		template.update("user.increaseUncompletedTodoAmount", userno);
	}

	@Override
	public void decreaseUncompletedTodoAmount(int userno) {
		template.update("user.decreaseUncompletedTodoAmount", userno);
	}

	@Override
	public void increaseCompletedTodoAmount(int userno) {
		template.update("user.increaseCompletedTodoAmount", userno);
	}

	@Override
	public void decreaseCompletedTodoAmount(int userno) {
		template.update("decreaseCompletedTodoAmount", userno);
	}
}
