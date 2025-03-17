package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *   스프링 프레임워크 
 *   ------------
 *   1. Container : 클래스를 모아서 관리 
 *      BeanFactory : core (객체 생성 / DI) 
 *         |
 *     ApplicationContext : default  core (객체 생성 / DI / AOP) 
 *         |
 *    WebApplicationContext : core (객체 생성 / DI / AOP / MVC) 
 *    
 *    => GenericApplicationContext => 닫기 (객체 소멸) 
 *    => AnnotationConfigApplicationContext 
 *       => 5버전 주로 사용
 *          ---- 보안에 주력 
 *          등록 : XML => 순수자바 설정이 가능 
 *                       ----- Boot  
 *      기능 
 *       = 객체 생명주기 관리 (생성 ~ 소멸) => 모든 클래스 (VO=>데이터형)
 *       = 객체 찾기 (getBean())
 *       = DL(객체 찾기) / DI (변수의 초기화)
 *                      --------------
 *                      1. setter
 *                      2. contstructor 
 *                      3. method호출이 가능 
 *     ---------------------------------------------------- 
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        	 new ClassPathXmlApplicationContext("app1.xml");
        Sawon sa=(Sawon)app.getBean("sa1");
        sa.print();
        
        Sawon sa1=(Sawon)app.getBean("sa2");
        sa1.print();
        
        Sawon sa2=(Sawon)app.getBean("sa3");
        sa2.print();
        
        Sawon sa3=(Sawon)app.getBean("sa4");
        sa3.print();
        
        Sawon sa4=(Sawon)app.getBean("sa5");
        sa4.print();
        
	}

}
