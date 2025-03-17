package com.sist.spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //ApplicationContext app=
        		//new ClassPathXmlApplicationContext("app3.xml");
		GenericApplicationContext app=
				new GenericXmlApplicationContext("app3.xml");
		
        Student std=(Student)app.getBean("std");
        System.out.println("학번:"+std.getHakbun());
        System.out.println("이름:"+std.getHuman().getName());
        System.out.println("성별:"+std.getHuman().getSex());
        System.out.println("주소:"+std.getHuman().getAddress());
        app.close();// System.gc()
        
	}

}
