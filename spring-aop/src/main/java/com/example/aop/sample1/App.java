package com.example.aop.sample1;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.service.ProductService;

public class App {
	
	public static void main(String[] args) {
		
		String resources = "classpath:/com/example/aop/sample1/bean.xml";
		GenericXmlApplicationContext container = new GenericXmlApplicationContext(resources);
		
		ProductService service = container.getBean("productService", ProductService.class);
		service.deleteAllProducts();
		service.deleteProductByNo(100);
		service.searchProductNameByPrice(10000, 20000);
		container.close();
	}
}
