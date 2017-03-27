package kr.co.jhta.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.todo.dao.TodoDAO;
import kr.co.jhta.todo.dao.UserDAO;
import kr.co.jhta.todo.vo.Todo;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private UserDAO userDao;
	@Autowired
	private TodoDAO todoDao;
	
	@Override
	public void registerTodo(Todo todo) {
		todoDao.addTodo(todo);
		userDao.increaseUncompletedTodoAmount(todo.getUser().getNo());
	}

	@Override
	public List<Todo> getTodoList(int no) {
		return todoDao.getTodoListByUserNo(no);
	}

	@Override
	public void completeTodo(int no, int userNo) {
		Todo todo = todoDao.getTodoByNo(no);
		
		if (todo != null) {
			if (todo.getUser().getNo() != userNo) {
				throw new RuntimeException("본인이 등록한 일정만 완료처리할 수 있습니다.");
			}

			todoDao.completeTodoByNo(no);
			userDao.increaseCompletedTodoAmount(userNo);
			userDao.decreaseUncompletedTodoAmount(userNo);
		}
	}

	@Override
	public String getAttachFilename(int no, int userNo) {
		Todo todo = todoDao.getTodoByNo(no);
		
		if (todo != null) {
			if (todo.getAttachFilename() == null) {
				throw new RuntimeException("해당 일정에는 등록된 첨부파일이 없습니다.");
			}
			
			if (todo.getUser().getNo() != userNo) {
				throw new RuntimeException("본인이 등록한 첨부파일만 다운로드 할 수 있습니다.");
			}
			
			return todo.getAttachFilename();
		}
		
		return null;
	}
}
