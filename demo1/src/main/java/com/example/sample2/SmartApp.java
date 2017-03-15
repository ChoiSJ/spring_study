package com.example.sample2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SmartApp {
	
	public static void main(String[] args) {
		
		String resources = "classpath:/com/example/sample2/bean.xml";
		GenericXmlApplicationContext container = new GenericXmlApplicationContext(resources);
		
		SmartPhone p = container.getBean("phone", SmartPhone.class);
		p.call();
		p.disconnect();
		
		SmartTV t = container.getBean("tv", SmartTV.class);
		t.display();
		t.web();
		
		container.close();
	}
}
