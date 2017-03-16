package com.example;

public class MemberServiceImpl implements MemberService {
	
	@Override
	public void addNewMember(String name) {
		// 공통기능 -- 실행되는 메소드의 이름을 화면에 표시하는 작업
		System.out.println("addNewMember() 가 실행됨");
		
		// 핵심기능 구현 -- db 에 사용자정보를 저장하는 작업
		System.out.println(name + "고객 저장완료... <--- 핵심기능");
	}
	
	@Override
	public void deleteAllMember() {
		// 공통기능 -- 실행되는 메소드의 이름을 화면에 표시하는 작업
		System.out.println("deleteAllMember() 가 실행됨");
		
		// 핵심기능 구현 -- db 에서 사용자정보 삭제하는 작업
		System.out.println("사용자정보 삭제 완료... <--- 핵심기능");
	}
}
