package kr.co.jhta.dao;

import java.util.List;

import kr.co.jhta.model.Todo;

public interface TodoDao {

	Integer getSequence();
	void saveTodo(Todo todo);
	Todo getTodoById(Integer id);
	List<Todo> getAllTodos();
	void deleteTodoById(Integer id);
	void updateTodo(Todo todo);
}
