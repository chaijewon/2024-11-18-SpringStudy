package com.sist.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.goods.*;
import com.sist.member.*;
import com.sist.sawon.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app1.xml");
        SawonManager sa=(SawonManager)app.getBean("sa");
        sa.display();
        GoodsManager goods=app.getBean("goods",GoodsManager.class);
        goods.display();
        MemberManager mem=(MemberManager)app.getBean("memberManager");
	}

}
