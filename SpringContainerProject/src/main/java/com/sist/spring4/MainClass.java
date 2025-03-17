package com.sist.spring4;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Container c=new Container();
        A a=(A)c.getBean("a");
        a.display();
        
        B b=(B)c.getBean("b");
        b.display();
        
        
        C c1=(C)c.getBean("c");
        c1.display();
	}

}
