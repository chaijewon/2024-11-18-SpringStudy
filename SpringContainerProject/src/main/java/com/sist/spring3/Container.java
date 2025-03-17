package com.sist.spring3;
import java.util.*;
public class Container {
   private Map clsMap=new HashMap();
   // 팩토리 패턴 => 싱글턴 패턴 
   // 단순한 관계 (경량) / 메모리 누수현상을 방지 
   /*
    *   1. 클래스 모아서 관리 
    *   2. 객체 생성 - 소멸 
    *         ---- 멤버변수의 초기화 (DI) => Inject 
    *   3. 객체를 찾아주는 역할 
    *      --------------- (DL) => Lookup
    *      
    *   4. 공통기반의 기능을 모아서 자동화 처리 => 공통모듈 : 콜백함수 
    *                                    -------------- AOP
    *   5. MVC : 라이브러리 
    *   6. ORM : 마이바티스 / JPA ...
    *      => 트랜잭션 
    *   7. Task (스케쥴러) / 보안 
    *      
    *    ----------------------
    *    1) XML 
    *    2) Annotation     
    *    
    *     => 동작이 가능하게 기본 틀이 만들어져 있다 
    *                    -----
    *        | 메인보드   
    */
   public Container()
   {
	   clsMap.put("a",new A());
	   clsMap.put("b",new B());
	   clsMap.put("c",new C());
   }
   public I getBean(String key)
   {
	   return (I)clsMap.get(key);
   }
}
