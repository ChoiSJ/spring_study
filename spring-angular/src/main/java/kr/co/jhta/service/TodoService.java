package kr.co.jhta.service;

import java.util.List;

import kr.co.jhta.model.Todo;

public interface TodoService {

	Todo insertTodo(Todo todo);
	List<Todo> getAllTodos();
	Todo getTodo(Integer id);
	Todo deleteTodo(Integer id);
	void updateTodo(Todo todo);
}
