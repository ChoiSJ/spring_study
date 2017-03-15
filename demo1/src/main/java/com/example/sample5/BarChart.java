package com.example.sample5;

public class BarChart implements Chart {
	
	private String color;
	private int gap;
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setGap(int gap) {
		this.gap = gap;
	}
	
	@Override
	public void draw() {
		System.out.println("통계 데이터를 바차트로 표시합니다.");
		System.out.println("바의 색 ["+color+"] 바의 간격 ["+gap+"]");
	}
}
