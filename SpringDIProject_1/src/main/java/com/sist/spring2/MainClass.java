package com.sist.spring2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app4.xml");
        EmpDAO dao=(EmpDAO)app.getBean("dao");
        List<EmpVO> list=dao.empAllData();
        for(EmpVO vo:list)
        {
        	System.out.println(vo.getEname()+" "
        			+vo.getDbday()+" "
        			+vo.getSal());
        }
	}

}
