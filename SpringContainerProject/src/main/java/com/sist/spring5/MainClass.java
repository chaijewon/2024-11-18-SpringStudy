package com.sist.spring5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 *   스프링에서 XML을 읽어서 
 *     1) 메모리 할당 
 *     2) Map에 저장 
 *     3) 대기 
 *     4) 객체 소멸 
 *     
 *     컨테이너 => 객체의 생명 주기 관리 
 *              ----------------
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        	new ClassPathXmlApplicationContext("application.xml");
        Sawon sa=(Sawon)app.getBean("sawon");
        // 저장된 (관리) 클래스 찾기 => DL => getBean()
        sa.display();
	}

}
