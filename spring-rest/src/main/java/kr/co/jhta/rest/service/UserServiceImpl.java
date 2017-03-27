package kr.co.jhta.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import kr.co.jhta.rest.vo.User;

@Service
public class UserServiceImpl implements UserService {
	
	private static List<User> db;
	private static AtomicInteger counter = new AtomicInteger(1);
	
	static {
		db = new ArrayList<User>();
		
		db.add(new User(counter.getAndIncrement(), "hong", "2222", "홍진호", "010-2222-2222", "hong@gmail.com"));
		db.add(new User(counter.getAndIncrement(), "imyh", "1111", "임요환", "010-1111-1111", "im@gmail.com"));
	}

	@Override
	public List<User> getAllUsers() {
		return db;
	}

	@Override
	public User getUserByNo(int no) {
		for (User user : db) {
			if (user.getNo() == no) {
				return user;
			}
		}
		
		return null;
	}

	@Override
	public User saveUser(User user) {
		user.setNo(counter.getAndIncrement());
		db.add(user);
		
		return null;
	}
}
