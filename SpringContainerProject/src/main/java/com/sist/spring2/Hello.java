package com.sist.spring2;
/*
 *    A <==> B
 *    
 *    A <==> I <==> B
 *         ----
 *         | 인터페이스가 오류가 나면 
 *           인터페이스와 관련된 모든 클래스가 오류
 *           ------- 고정해서 사용
 *           
 *    => 결합성이 낮은 프로그램을 구현 
 *    => ---------------- 세미나 => 발표자 (로드존슨) 
 *                                     -------- Open Source
 *                                              -----------
 *                                              spring.io
 *                                              ---------
 *                                              | 발전 : 2.5
 *      웹로직 / 웹스페어 => 툴사용 : 비용이 비싸다 
 *                             ----------- 스프링 (무료)
 *                             
 */
public interface Hello {
   public String sayHello(String name);
}
