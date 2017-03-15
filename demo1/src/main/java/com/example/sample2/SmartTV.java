package com.example.sample2;

import org.springframework.stereotype.Component;

@Component("tv")
public class SmartTV {
	
	public void display() {
		System.out.println("최신 컨텐츠를 화면에 표시합니다.");
	}
	
	public void web() {
		System.out.println("웹 서핑을 합니다.");
	}
}
