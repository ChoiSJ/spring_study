package com.example.aop.sample2;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.example.vo.Role;

@Aspect
public class MyAspect {
	
	@Around("within(com.example.service.AdminService+) && args(.., role)")
	public Object security(ProceedingJoinPoint jp, Role role) throws Throwable {
		System.out.println("[security around advice]role:" + role.getUsername() + ", " + role.getType());
		
		if ("ADMIN".equals(role.getType())) {
			Object returnValue = jp.proceed();
			return returnValue;
		} else {
			throw new RuntimeException("권한 부족...");
		} 
	}
	
	@Around("within(com.example.service.Operator+)")
	public Object profiling(ProceedingJoinPoint jp) throws Throwable {
		try {
			// 전처리 코드 <-- BeforeAdvice
			Object[] args = jp.getArgs();
			System.out.println("[around advice 전처리]매개변수 값: " + Arrays.toString(args));
			
			// 대상메소드를 실행하는 코드
			// 대상메소드의 실행결과값을 returnValue 에 저장한다.
			//Object returnValue = jp.proceed(new Object[] {100, 200});
			Object returnValue = jp.proceed();
			
			// 후처리 코드 <-- AfterReturning Advice
			System.out.println("[around advice 후처리]결과값: " + returnValue.toString());
			
			// 대상메소드의 실행결과값을 반환한다.
			return returnValue;
			
		} catch (Throwable t) {
			// 예외처리 코드 <-- AfterThrowing Advice
			System.out.println("[around advice 에러처리]오류메세지: " +  t.getMessage());
			System.out.println("[around advice 에러처리]오류클래스: " +  t.getClass().getSimpleName());
			throw t; 
		} finally {
			// <- After Advice 역할
			System.out.println("[around advice]around 공통기능 수행 종료");
		}
	}
}
