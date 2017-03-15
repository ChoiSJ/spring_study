package com.example.sample8;

public class FacebookSender implements Sender {
	
	@Override
	public void send(String message) {
		System.out.println("[facebook 발송]" + message);
	}
}
