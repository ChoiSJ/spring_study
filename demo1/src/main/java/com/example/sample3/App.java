package com.example.sample3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		String resources = "classpath:/com/example/sample3/bean.xml";
		GenericXmlApplicationContext container = new GenericXmlApplicationContext(resources);
		
		EventNotificationService service = 
				container.getBean("eventService", EventNotificationService.class);
		service.notice("오늘은 내가 짜파게티 요리사!!!");
		
		container.close();
	}
}
