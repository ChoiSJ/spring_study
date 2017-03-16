package com.example;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		String resources = "classpath:/com/example/bean.xml";
		GenericXmlApplicationContext container = new GenericXmlApplicationContext(resources);
		MemberService service = container.getBean("service", MemberService.class);
		service.addNewMember("홍진호");
		System.out.println(service);
		container.close();
	}
}
