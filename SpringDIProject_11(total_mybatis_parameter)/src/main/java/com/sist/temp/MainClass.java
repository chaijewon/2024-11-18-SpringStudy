package com.sist.temp;

import java.lang.reflect.Method;

class A
{
	public void aaa() {
		System.out.println("A:aaa() Call...");
	}
	public void bbb() {
		System.out.println("A:bbb() Call...");
	}
	public void ccc() {
		System.out.println("A:ccc() Call...");
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	Class clsName=Class.forName("com.sist.temp.A");
        	Object obj=clsName.getDeclaredConstructor().newInstance();
        	Method[] methods=clsName.getDeclaredMethods();
        	
        	methods[0].invoke(obj, null);
        	
        }catch(Exception ex){}
	}

}
