package com.example.sample8;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		String resources = "classpath:/com/example/sample8/bean.xml";
		GenericXmlApplicationContext container = new GenericXmlApplicationContext(resources);
		
		//MessageSenderList sender = container.getBean("messageSender3", MessageSenderList.class);
		//sender.sendMessage("오늘부터 3일 동안 파격세일을 진행합니다.");
		
		MessageSenderMap sender = container.getBean(MessageSenderMap.class);
		sender.sendMessage("F", "오늘부터 3일 동안 파격세일을 진행합니다.");
		container.close();
	}
}
