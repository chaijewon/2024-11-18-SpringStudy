package com.sist.spring1;
/*
 *    HelloMain는 Hello에 의존한다 => 결합성이 강한 프로그램 
 *                                ----------------
 *                                | 유지보수가 어렵다 
 *                                | 에러시에 다른 클래스가 에러가 나는 경우
 *    가급적이면 => new를 사용하지 않는다 
 *               ----- 결합성이 높은 프로그램 
 */
public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Hello hello=new Hello();
        String msg=hello.seyHello("홍길동");
        System.out.println(msg);
	}

}
