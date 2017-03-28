package kr.co.jhta.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.jhta.rest.service.UserService;
import kr.co.jhta.rest.vo.User;

@RestController
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	// 모든 사용자 정보 조회
	@GetMapping(path="/user/")
	public @ResponseBody List<User> listAllUser() {
		List<User> users = userService.getAllUsers();
		
		return users;
	}
	
	// 특정 번호에 해당하는 사용자 한 명 조회
	@GetMapping(path="/user/{no}")
	public User getUser(@PathVariable("no") int no) {
		User user = userService.getUserByNo(no);
		
		return user;
	}
	
	// 새로운 사용자 생성하기
	@PostMapping(path="/user/")
	public @ResponseBody User saveUser(@RequestBody User user) {
		user = userService.saveUser(user);
		
		return user;
	}
	
	@DeleteMapping(path="/user/{no}")
	public @ResponseBody User deleteUser(@PathVariable("no") int no) {
		User user = userService.deleteUser(no);
		
		return user;
	}
	
	@PutMapping(path="/user/{no}")
	public @ResponseBody User updateUser(@PathVariable("no") int no, @RequestBody User user) {
		System.out.println("no["+no+"]번의 사용자 정보 수정");
		
		userService.updateUser(user);
		
		return user;
	}
}
