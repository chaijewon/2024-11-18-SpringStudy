package com.sist.commons;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerException {
	   @ExceptionHandler(Exception.class)
	   public void exception(Exception ex)
	   {
		   System.out.println("========== 오류 발생 ==========");
		   ex.printStackTrace();
	   }
}
