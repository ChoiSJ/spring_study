package com.example.sample3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderNotificationService {
	
	@Autowired
	SMSService smsService;
	
	public void notify(String message) {
		String userName = "홍진호";
		String phoneNumber = "010-2222-2222";
		
		smsService.send(phoneNumber, "["+userName+"] 님" + message);
	}
}
