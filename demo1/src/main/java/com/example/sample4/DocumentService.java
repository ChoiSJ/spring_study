package com.example.sample4;

import org.springframework.beans.factory.annotation.Autowired;

public class DocumentService {
	
	// Printer 인터페이스를 구현한 객체를 주입해주세요.
	@Autowired
	Printer printer;
	
	public void PrintContent(String content) {
		// Printer 인터페이스를 구현한 객체에 재정의된 print() 를 실행하는 코드
		printer.print(content);
	}
}
