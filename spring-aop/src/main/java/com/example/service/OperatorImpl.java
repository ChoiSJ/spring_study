package com.example.service;

public class OperatorImpl implements Operator {
	
	@Override
	public int plus(int x, int y) {
		System.out.println("### 더하기 핵심기능 실행 중...");
		return x + y;
	}
	
	@Override
	public int minus(int x, int y) {
		System.out.println("### 빼기 핵심기능 실행 중...");
		return x - y;
	}
	
	@Override
	public int mutiple(int x, int y) {
		System.out.println("### 곱하기 핵심기능 실행 중...");
		return x*y;
	}
	
	@Override
	public int divide(int x, int y) {
		System.out.println("### 나누기 핵심기능 실행 중...");
		return x/y;
	}
}
