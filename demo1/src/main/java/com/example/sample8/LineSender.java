package com.example.sample8;

public class LineSender implements Sender {
	
	@Override
	public void send(String message) {
		System.out.println("[line 발송]" + message);	
	}
}
