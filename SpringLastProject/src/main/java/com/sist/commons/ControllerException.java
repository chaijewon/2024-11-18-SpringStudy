package com.sist.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {
   @ExceptionHandler(Exception.class)
   public void exception(Exception ex)
   {
	   System.out.println("========== 오류 발생 ==========");
	   ex.printStackTrace();
   }
}
