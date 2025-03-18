package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //String[] xml={"app-member.xml","app-sawon.xml","app-student.xml"};
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app-*.xml");
        Sawon sa=(Sawon)app.getBean("sa");
        System.out.println(sa.getSabun());
        System.out.println(sa.getName());
        System.out.println(sa.getDept());
        System.out.println("============");
        
	}

}
