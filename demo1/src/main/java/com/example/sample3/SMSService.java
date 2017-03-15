package com.example.sample3;

import org.springframework.stereotype.Service;

@Service("sms")
public class SMSService {
	
	public void send(String tel, String message) {
		System.out.println("["+tel+"]" + message);
	}
}
