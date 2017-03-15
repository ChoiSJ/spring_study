package com.example.sample9;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		String resources = "classpath:/com/example/sample9/bean.xml";
		GenericXmlApplicationContext container = new GenericXmlApplicationContext(resources);
		TV tv = container.getBean("tv", TV.class);
		tv.on();
		container.close();
	}
}
