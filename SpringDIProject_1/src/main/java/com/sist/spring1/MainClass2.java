package com.sist.spring1;
/*
 *   1. 개발자 => 클래스 메모리 할당을 하지 않는다 
 *              ------------- 모든 클래스의 메모리 할당 요청 
 *                            --------  ------------ XML,Annotation이용
 *                              관리할 수 있게 만든다 
 *                              ---------------
 *                                생성 ~ 소멸 
 *                                --- 변수의 초기화 
 *                                | 메모리 누수 현상 방지 
 *      스프링은 클래스 관리자 => 컨테이너 
 *                          경량 => 클래스간의 연관 관계가 단순하다 
 *                           
 *      <bean> => @Bean
 *      <select> => @Select()      
 *      => DAO 
 *      
 *     ==================================================
 *     Spring => 클래스 관리 (컨테이너) 
 *               -------- 기능만 가지고 있다 (컴포넌트)
 *               | XML => 동작을 위한 메뉴얼 작업 
 *                 클래스와 클래스의 연관관계를 설정 
 *                 ------------------------ DI
 *                 | DI / AOP / 트랜잭션 / MVC
 *              컨테이너 
 *                | DL / DI
 *                       주입 (초기화가 필요한 변수에 대한 값을 설정)
 *                       예) 데이터베이스 연결 
 *                          => 드라이버 / URL / UserName / Password
 *                          => Security  
 *                       = setter DI
 *                       = constructor DI
 *                       -----------------------------
 *                       = 생성시 메소드 : init-method
 *                       = 소멸시 메소드 : destory-method
 *                       ----------------------------- 메소드 DI 
 *                  객체 찾기 : getBean() / @Autowired
 *                  -------
 *                   대상 : Model , DAO , Manager , Service
 *                        관리대상 
 *                   제외 : VO , DTO , Bean => 사용자 정의 데이터형 
 *                         => int / double ...   
 *                  
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
