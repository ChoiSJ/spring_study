package kr.co.jhta.todo.dao;

import java.util.List;

import kr.co.jhta.todo.vo.Todo;

public interface TodoDAO {
	
	void addTodo(Todo todo);
	List<Todo> getTodoListByUserNo(int userNo);
	Todo getTodoByNo(int no);
	void completeTodoByNo(int no);
}
