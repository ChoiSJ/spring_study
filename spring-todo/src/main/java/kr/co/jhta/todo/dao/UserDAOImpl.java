package kr.co.jhta.todo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.jhta.todo.vo.User;

@SuppressWarnings("depercation")
@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlMapClientTemplate template;
	
	@Override
	public void addUser(User user) {
		template.insert("addUser", user);
	}
	
	@Override
	public User getUserById(String id) {
		return (User) template.queryForObject("getUserById", id);
	}
}
