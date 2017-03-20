package com.example.aop.sample1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.exception.HTAException;


// Aspect = Advice(What + When) + Pointcut(Where)
// @Aspect 어노테이션은 이 클래스가 AOP 적용에 필요한 설정이 정의된 클래스임을 나타낸다.
@Aspect
public class MyAdvice {
	
	@Pointcut("execution(* com.example.service.ProductService.find*(..))")
	public void findpointcut() {}
	
	@Pointcut("execution(* com.example.service.ProductService.search*(..))")
	public void searchpointcut() {}
	
	// where
	@Pointcut("execution(* com.example.service.ProductService.*(..))")
	public void mypointcut() {}
	
	@AfterThrowing(pointcut="within(com.example.service.Operator+)", throwing="ex")
	public void loggingException(JoinPoint jp, Exception ex) throws Exception {
		Class<?> clazz = jp.getTarget().getClass();
		Logger logger = LoggerFactory.getLogger(clazz);
		
		// 발생한 예외 정보를 로그로 출력한다.
		String targetClassName = clazz.getName();
		String methodName = jp.getSignature().getName();
		String exceptionName = ex.getClass().getSimpleName();
		String errorMessage = ex.getMessage();
		
		StringBuilder message = new StringBuilder();
		message.append("예외 발생\n");
		message.append("------------------------------------------------------------\n");
		message.append("예외발생 클래스		: {}\n");
		message.append("예외발생 메소드		: {}\n");
		message.append("발생된 예외클래스	: {}\n");
		message.append("에러 메시지		: {}\n");
		message.append("------------------------------------------------------------\n");
		
		logger.error(message.toString(), 
				targetClassName, methodName, exceptionName, errorMessage);
		
		throw new HTAException(errorMessage);
	}
	
	@AfterReturning(pointcut="findpointcut() || searchpointcut()", returning="ret")
	public void loggingReturnValue(JoinPoint jp, Object ret) {
		if (ret == null) {
			System.out.println("반환값이 없습니다.");
		} else {
			System.out.println("결과값:" + ret);			
		}
	}
	
	// when
	@Before("mypointcut()")
	public void logging(JoinPoint jp) {
		// what
		Signature signature = jp.getSignature();		
		
		// 대상객체의 이름 조회하기
		String targetClassName = jp.getTarget().getClass().getName();
		
		// 대상메소드의 이름 조회하기
		String methodName = jp.getSignature().getName();
		
		// 대상메소드가 전달받은 매개변수값 정보 조회하기
		Object[] args = jp.getArgs();
		
		StringBuilder argTypeBuilder = new StringBuilder();
		StringBuilder argValueBuilder = new StringBuilder();
		
		int count = 0;
		
		for (Object arg : args) {
			// 매개변수의 타입이름 조회하기
			String argTypeName = arg.getClass().getSimpleName();
			
			if (count > 0) {
				argTypeBuilder.append(", ");
			}
			// 조회된 매개변수의 타입을 argTypeBuilder 에 추가하기
			argTypeBuilder.append(argTypeName + " arg" + ++count);
			// 조회된 매개변수의 값을 argValueBuilder 에 추가하기
			argValueBuilder.append(".arg" + count + ":" + arg.toString() + "\n");
		}
		
		if (count == 0) {
			argValueBuilder.append("매개변수 없음\n");
		}
		
		// 메세지 출력포맷을 만들기
		StringBuilder message = new StringBuilder();
		message.append("{} ({}) 메소드 실행.");
		message.append("\n----------------------------------------\n");
		message.append("{}----------------------------------------\n");
		
		// 대상객체의 클래스 타입을 조회하기
		Class<?> clazz = jp.getTarget().getClass();
		// 대상객체의 클래스타입으로 Logger 객체 얻기
		Logger logger = LoggerFactory.getLogger(clazz);
		// 로그 출력하기
		logger.info(message.toString(), 
				methodName, argTypeBuilder.toString(), argValueBuilder.toString());
	}
}
