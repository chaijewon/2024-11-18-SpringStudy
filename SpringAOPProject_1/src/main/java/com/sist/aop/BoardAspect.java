package com.sist.aop;

public class BoardAspect {
   public void before()
   {
	   System.out.println("오라클 연결!!");
   }
   public void after()
   {
	   System.out.println("오라클 닫기!!");
   }
}
