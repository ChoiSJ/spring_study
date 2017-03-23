package kr.co.jhta.todo.service;

import java.util.List;

import kr.co.jhta.todo.vo.Todo;

public interface TodoService {
	
	void registerTodo(Todo todo);
	List<Todo> getTodoList(int no);
	void completeTodo(int no, int userNo); 
}
