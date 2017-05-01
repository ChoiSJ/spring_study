package kr.co.jhta.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.jhta.model.Todo;
import kr.co.jhta.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/todos/", method=RequestMethod.POST)
	public @ResponseBody Todo saveTodo(@RequestBody Todo todo) {
		return todoService.insertTodo(todo);
	}
	
	@RequestMapping(value="/todos/", method=RequestMethod.GET)
	public @ResponseBody List<Todo> getTodos() {
		return todoService.getAllTodos();
	}
	
	@RequestMapping(value="/todos/${id}", method=RequestMethod.GET)
	public @ResponseBody Todo getTodo(@PathVariable("id") Integer id) {
		return todoService.getTodo(id);
	}
	
	@RequestMapping(value="/todos/${id}", method=RequestMethod.DELETE)
	public @ResponseBody Todo deleteTodo(@PathVariable("id") Integer id) {
		return todoService.deleteTodo(id);
	}
	
	@RequestMapping(value="/todos/${id}", method=RequestMethod.PUT)
	public @ResponseBody Todo updateTodo(@RequestBody Todo todo) {
		todoService.updateTodo(todo);
		return todo;
	}
}
