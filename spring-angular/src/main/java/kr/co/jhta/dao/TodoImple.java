package kr.co.jhta.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.co.jhta.model.Todo;

@Repository
public class TodoImple implements TodoDao {
	
	private static final String INSERT_TODO_SQL = "insert into tb_todo(id, title, description, event_date, completed) values(?, ?, ?, ?, ?)";
	private static final String SELECT_TODO_SQL = "select * from tb_todo where id = ?";
	private static final String SELECT_ALL_TODO_SQL = "select * from tb_todo order by id";
	private static final String DELETE_TODO_SQL = "delete from tb_todo where id = ?";
	private static final String UPDATE_TODO_SQL = "update tb_todo set title=?, description=?, event_date =?, completed = ? where id = ?";
	private static AtomicInteger counter = new AtomicInteger(100);
	
	@Autowired
	private JdbcTemplate template;

	@Override
	public Integer getSequence() {
		return counter.getAndIncrement();
	}	
	
	@Override
	public void saveTodo(Todo todo) {
		template.update(INSERT_TODO_SQL, todo.getId(), todo.getTitle(), todo.getDescription(), todo.getEventDate(), todo.isCompleted());
	}

	@Override
	public Todo getTodoById(Integer id) {
		return template.queryForObject(SELECT_TODO_SQL, new RowMapper<Todo>() {
			@Override
			public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
				Todo todo = new Todo();
				todo.setId(rs.getInt("id"));
				todo.setTitle(rs.getString("title"));
				todo.setDescription(rs.getString("description"));
				todo.setEventDate(rs.getDate("event_date"));
				todo.setCompleted(rs.getBoolean("completed"));
				return todo;
			}
		}, id);
	}

	@Override
	public List<Todo> getAllTodos() {
		return template.query(SELECT_ALL_TODO_SQL, new RowMapper<Todo>() {
			@Override
			public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
				Todo todo = new Todo();
				todo.setId(rs.getInt("id"));
				todo.setTitle(rs.getString("title"));
				todo.setDescription(rs.getString("description"));
				todo.setEventDate(rs.getDate("event_date"));
				todo.setCompleted(rs.getBoolean("completed"));
				return todo;
			}
		});
	}

	@Override
	public void deleteTodoById(Integer id) {
		template.update(DELETE_TODO_SQL, id);
	}

	@Override
	public void updateTodo(Todo todo) {
		template.update(UPDATE_TODO_SQL, todo.getTitle(), todo.getDescription(), todo.getEventDate(), todo.isCompleted(), todo.getId());
	}
}
