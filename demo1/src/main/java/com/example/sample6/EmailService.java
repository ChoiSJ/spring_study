package com.example.sample6;

public class EmailService {
	
	private String host;
	private int port;
	private String username;
	private String password;
	
	public EmailService(String host, int port, String username, String password) {
		super();
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
	}
	
	public void connect() {
		System.out.println("["+host+"] ["+port+"] ["+username+"] ["+password+"] 로 연결시도...");
	}
}
