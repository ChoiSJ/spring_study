package com.example;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.dao.UserDAO;
import com.example.vo.User;

public class App {
	
	public static void main(String[] args) {
		
		String resources = "classpath:/META-INF/spring/applicationContext.xml";
		GenericXmlApplicationContext container = new GenericXmlApplicationContext(resources);
		UserDAO dao = container.getBean("userDao", UserDAO.class);
		
		dao.deleteAllUser();
		User user1 = new User(1, "홍진호", "010-2222-2222", "hong@gmail.com");
		User user2 = new User(2, "임요환", "010-1111-1111", "im@gmail.com");
		User user3 = new User(3, "이윤열", "010-1234-5678", "lee@gmail.com");
		
		dao.addNewUser(user1);
		dao.addNewUser(user2);
		dao.addNewUser(user3);
		
		List<User> users = dao.getAllUsers();
		
		for (User user : users) {
			System.out.println(user.getId() + ", " + user.getName());
		}
		
		User user = dao.getUserById(2);
		System.out.println(user.getId() + ": " + user.getName() + ", " + user.getPhone());
		container.close();
	}
}
