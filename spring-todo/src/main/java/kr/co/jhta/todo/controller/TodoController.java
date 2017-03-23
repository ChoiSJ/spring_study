package kr.co.jhta.todo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.todo.service.TodoService;
import kr.co.jhta.todo.vo.Todo;
import kr.co.jhta.todo.vo.TodoForm;
import kr.co.jhta.todo.vo.User;

@Controller
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@RequestMapping(value="/addtodo.do", method=RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("todoForm", new TodoForm());
		return "registertodo";
   }
   
	@RequestMapping(value="/addtodo.do", method=RequestMethod.POST)
	public String register(@Valid @ModelAttribute("todoForm") TodoForm todoform, Errors errors,
			HttpSession session){
		if(errors.hasErrors()){
			return "registertodo";
		}
		
		Todo todo = new Todo();
		BeanUtils.copyProperties(todoform, todo);
		User user = (User) session.getAttribute("LOGIN_USER");
		todo.setUser(user);
		todoService.registerTodo(todo);
		
		return "redirect:/todo.do";
	}
	
	@RequestMapping("/todo.do")
	public String todos(Model model, HttpSession session) {
		User user = (User) session.getAttribute("LOGIN_USER");
		List<Todo> todoList = todoService.getTodoList(user.getNo());
		model.addAttribute("todoList", todoList);
		
		return "todo";
	}
	
	@RequestMapping("/complete.do")
	public String complete(@RequestParam("no") int no, HttpSession session) {
		User user = (User) session.getAttribute("LOGIN_USER");
		todoService.completeTodo(no, user.getNo());
		
		return "redirect:/todo.do";
	}
}
