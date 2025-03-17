package com.sist.spring3;
// 여러개 클래스 모아서 관리 => 컨테이너 
public class B implements I{

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("B:sayHello() Call...");
	}

}
