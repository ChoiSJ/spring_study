package com.example.sample10;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		String resources = "classpath:/com/example/sample10/bean.xml";
		GenericXmlApplicationContext container = new GenericXmlApplicationContext(resources);
		FileUploadService service = container.getBean(FileUploadService.class);
		service.displayUploadConf();
		container.close();
	}
}
