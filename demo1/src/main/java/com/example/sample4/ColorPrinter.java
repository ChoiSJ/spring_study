package com.example.sample4;

public class ColorPrinter implements Printer {
		
	@Override
	public void print(String text) {
		System.out.println("[컬러출력]" + text);	
	}
}
