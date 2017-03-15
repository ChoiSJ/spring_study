package com.example.sample5;

public class Reporting {
	
	// Chart 인터페이스를 구현한 객체가 필요하다.
	private Chart chart;
	private int width;
	private int height;
	
	// setter Injection 을 사용하기 위해서 setter 메소드 추가
	public void setChart(Chart chart) {
		this.chart = chart;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	// 조회된 데이터를 적절한 차트로 표시하기
	public void drawChart() {
		// 데이터베이스에서 데이터 조회
		// 데이터를 적절한 형태로 가공하기
		
		// 차트 그리기
		System.out.println("너비 ["+width+"] 높이 ["+height+"] 크기의 차트를 삽입");
		chart.draw();
	}
}
