package com.example.sample8;

public class KakaoTalkSender implements Sender {
	
	@Override
	public void send(String message) {
		System.out.println("[talk 발송]" + message);
	}
}
