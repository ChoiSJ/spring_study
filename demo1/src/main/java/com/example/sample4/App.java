package com.example.sample4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		String resources = "classpath:/com/example/sample4/bean.xml";
		GenericXmlApplicationContext container = new GenericXmlApplicationContext(resources);
		
		DocumentService docService = container.getBean("service", DocumentService.class);
		docService.PrintContent("이 내용을 출력바랍니다.");
		
		container.close();
	}
}
