package kr.co.jhta.rest.service;

import java.util.ArrayList;
import java.util.Date;
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
		user.setRegdate(new Date());
		db.add(user);
		
		return user;
	}

	@Override
	public User deleteUser(int no) {
		int userIndex = -1;
		
		for (int index=0; index<db.size(); index++) {
			User user = db.get(index);
			
			if (user.getNo() == no) {
				userIndex = index;
				break;
			}
		}
		
		if (userIndex != -1) {
			return db.remove(userIndex);
		}
		
		return null;
	}

	@Override
	public void updateUser(User user) {
		int userIndex = -1;
		
		for (int index=0; index<db.size(); index++) {
			User item = db.get(index);
			
			if (item.getNo() == user.getNo()) {
				userIndex = index;
				break;
			}
		}
		
		if (userIndex != -1) {
			db.set(userIndex, user);	// 지정한 위치의 객체를 새로운 객체로 교체
		}
	}
}
