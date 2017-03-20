package com.example.aop.sample2;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.service.AdminService;
import com.example.service.Operator;
import com.example.vo.Role;

public class App {
 
	public static void main(String[] args) {
		
		String resource = "classpath:/com/example/aop/sample2/bean.xml";
		GenericXmlApplicationContext container = new GenericXmlApplicationContext(resource);
		
		//Operator op = container.getBean("operator", Operator.class);
		//int result1 = op.plus(11, 22);
		//int result2 = op.divide(10, 0);
		
		AdminService service = container.getBean("adminService", AdminService.class);
		service.deleteUser("im", new Role("임요환", "ADMIN"));
		service.deleteUser("hong", new Role("홍진호", "USER"));
		container.close();
	}
}
