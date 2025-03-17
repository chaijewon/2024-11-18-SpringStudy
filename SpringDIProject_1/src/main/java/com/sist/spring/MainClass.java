package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        	 new ClassPathXmlApplicationContext("app2.xml");
        //       --------- src/main/java
        Member m1=app.getBean("mem",Member.class);
        System.out.println("번호:"+m1.getMno());
        System.out.println("이름:"+m1.getName());
        System.out.println("주소:"+m1.getAddress());
        
        Member m2=app.getBean("mem",Member.class);
        m2.setMno(2);
        m2.setName("심청이");
        m2.setAddress("경기");
        
        System.out.println("번호:"+m2.getMno());
        System.out.println("이름:"+m2.getName());
        System.out.println("주소:"+m2.getAddress());
        
        System.out.println("번호:"+m1.getMno());
        System.out.println("이름:"+m1.getName());
        System.out.println("주소:"+m1.getAddress());
	}

}
