package com.example.sample8;

public class SMSSender implements Sender {
	
	@Override
	public void send(String message) {
		System.out.println("[sms 발송]" + message);	
	}
}
