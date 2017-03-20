package com.example.service;

import com.example.vo.Role;

public class AdminServiceImpl implements AdminService {
	
	@Override
	public void deleteUser(String id, Role role) {
		System.out.println("["+id+"] 사용자 삭제 완료...");
	}
}
