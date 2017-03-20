package com.example.aop.sample1;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.service.Operator;

public class App2 {
	
	public static void main(String[] args) {
		
		String resources = "classpath:/com/example/aop/sample1/bean.xml";
		GenericXmlApplicationContext container = new GenericXmlApplicationContext(resources);
		
		Operator op = container.getBean("operator", Operator.class);
		op.divide(10, 0);
		container.close();		
	}
}
