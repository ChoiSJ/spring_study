package com.example.service;

import java.util.List;

public interface ProductService {
	
	void deleteAllProducts();
	void deleteProductByNo(int no);
	String findProductNameByNo(int no);
	List<String> searchProductNameByPrice(int min, int max);
}
