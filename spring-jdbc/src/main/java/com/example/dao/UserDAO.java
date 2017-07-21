package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.vo.User;

public class UserDAO {
	
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void addNewUser(User user) {
		String sql = "insert into tb_user (id, name, phone, email, regdate) values (?, ?, ?, ?, ?)";
		template.update(sql, user.getId(), user.getName(), user.getPhone(), user.getEmail(), user.getRegdate());
	}
	
	public void deleteAllUser() {
		String sql = "delete from tb_user";
		template.update(sql);
	}
	
	public List<User> getAllUsers() {
		String sql = "select id, name, phone, email, regdate from tb_user order by id";
		
		return template.query(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setRegdate(rs.getDate("regdate"));
				
				return user;
			}
		});
	}
	
	public User getUserById(int id) {
		String sql = "select * from tb_user where id = ?";
		
		return template.queryForObject(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setRegdate(rs.getDate("regdate"));
				
				return user;
			}
		} , id);
	}
}
