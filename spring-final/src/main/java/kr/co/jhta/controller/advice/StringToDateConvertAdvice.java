package kr.co.jhta.controller.advice;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class StringToDateConvertAdvice {

	@InitBinder
	   public void stringtoDateBinding(WebDataBinder binder){
	      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	      binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	   }
	
}
