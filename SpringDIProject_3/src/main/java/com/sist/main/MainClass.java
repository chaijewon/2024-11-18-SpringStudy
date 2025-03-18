package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        	new ClassPathXmlApplicationContext("app.xml");
        EmpDAO dao=(EmpDAO)app.getBean("dao");
        // EmpDAO dao=new EmpDAO()
        List<EmpVO> list=dao.empListData();
        for(EmpVO vo:list)
        {
        	System.out.println(vo.getEname()+" "
        			+vo.getDbday()+" "
        			+vo.getJob());
        }
	}

}
