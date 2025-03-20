package com.sist.main;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.config.FoodConfig;
import com.sist.service.FoodService;
import java.util.*;
import com.sist.vo.*;
/*
 *    <context:component-scan base-package="com.sist.*"/>
 *    @ComponentScan
 *    <mybatis-spring:scan base-package="com.sist.mapper" factory-ref="ssf"/>
 *    @MapperScan
 *    
 *    <bean>
 *    @Bean
 *    
 *    => 태그를 어오테이션으로 변경 => 매칭 
 */
@Component
public class MainClass {
	@Autowired
    private FoodService service;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(FoodConfig.class);
        //ApplicationContext app=
        		//new ClassPathXmlApplicationContext("application-*.xml");
        MainClass mc=(MainClass)app.getBean("mainClass");
        Scanner scan=new Scanner(System.in);
        System.out.print("Page 입력:");
        int page=scan.nextInt();
        List<FoodVO> list=
        	mc.service.foodListData((page*10)-9, page*10);
        for(FoodVO vo:list)
        {
        	System.out.println(vo.getFno()+"."
        			+vo.getName());
        }
	}

}
