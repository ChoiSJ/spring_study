package com.example.vo;

public class Role {
	
	private String username;
	private String type;
	
	public Role(String username, String type) {
		this.username = username;
		this.type = type;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getType() {
		return type;
	}
}
