package kr.co.jhta.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(RuntimeException.class)
	   public String runtimeExceptionHandler(RuntimeException ex) {
	      return "errors/server-error";
	   }
}
