package com.sist.commons;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
// 공통 예외처리 
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class CommonsException {
   @ExceptionHandler(SQLException.class)
   public void sqlException(SQLException ex)
   {
	   System.out.println("======== 데이터베이스 오류 =====");
	   ex.printStackTrace();
   }
   @ExceptionHandler(IOException.class)
   public void ioException(IOException ex)
   {
	   System.out.println("======== 입출력 오류 =====");
	   ex.printStackTrace();
   }
   @ExceptionHandler(Exception.class)
   public void exception(Exception ex)
   {
	   System.out.println("======== 기타 오류 =====");
	   ex.printStackTrace();
   }
}
