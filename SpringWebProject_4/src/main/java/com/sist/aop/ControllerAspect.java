package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/*
 *   기능이 있는 클래스 => 스프링이 관리 
 *                   객체 생성 ~ 소멸
 *                   ------
 *                   1. 메모리 할당 
 *                   2. 멤버변수의 초기화
 *                      DI => setXxx() , 생성자 
 *                      -- 값을 주입 
 *                   3. 필요시마다 객체를 찾아서 사용이 가능 
 *                      DL => @Autowired
 *                   ---------------------------
 *                    => 클래스 관리자 (Container)
 *                       복잡한 클래스 
 *                       --------- 관계도 많은 경우 
 *                        => 연관관계가 없는 독립적인 클래스 제작
 *                    => MVC는 스프링의 라이브러리다 
 *         객체 생성 요청 
 *         ----------
 *         각 클래스마다 메모리 할당 
 *         <bean id="" class="">
 *         => 모든 클래스 관리하는 것이 아니다 
 *            인터페이스 / 사용자 정의 데이터형 / 임시 클래스 (X)
 *            => WEB => 선택적 메모리 할당 
 *                  @Repository
 *               1. DAO 
 *                  @Service
 *               2. Service 
 *                  @Controller
 *               3. Model 
 *                  @Component
 *               4. Manager
 *                  @Component
 *               5. AOP
 *               
 *             => @RestController / @ControllerAdvice
 *             => 나머지는 개발자 관리 
 *             => DI 
 *                 = 객체의 생명주기 
 *                 = 클래스와 클래스의 연관 관계 설정 
 *                 ------------------------
 *                 오버로딩 / 오버라이딩 
 *                   |       |
 *                  new    modify 
 *      AOP : 공통모듈 (여러 위치에 호출)
 *            => 보안 / 로깅 / 트랜잭션 => 어노테이션 
 *               ---        -----
 *                |           |
 *                -------------
 *                      | 이미 만들어져 있다 
 *     중복 제거 
 *     ------
 *       OOP => 메소드 , 메소드 많은 경우 클래스 
 *       AOP => ----------------------- 자동 호출이 가능 
 *       ---- OOP를 보완 
 *        
 *        자동 호출 
 *        ------
 *        어떤 메소드에서 호출 : PointCut
 *        메소드 영역안에 어떤 위치에서 호출 : JoinPoint
 *        ----------------------------------- Advice
 *         public String display()
 *         {
 *            => Before
 *            try
 *            {
 *                =====시작점 Around
 *                소스
 *                =====끝 Around  => 트랜잭션,로그
 *            }catch(Exception e)
 *            {
 *               => After-Throwing
 *            }
 *            finally
 *            {
 *               => After
 *            }
 *            
 *            return "" =>After-Returning
 *         }
 *         
 *         PointCut 
 *         execution("* 패키지명.클래스.메소드(..)")
 *                    |                 |
 *                    리턴형              매개변수 (0개 이상)
 *         within("패키지") => 지정된 패키지에 있는 모든 클래스 적용
 *         
 *         => Advice(JoinPoint+PointCut) 
 *            ---------------------------여러개)Aspect
 *         
 *                 
 */
@Aspect
@Component
public class ControllerAspect {
   @Around("execution(* com.sist.web.*Controller.*(..))")
   public Object around(ProceedingJoinPoint jp)
   throws Throwable
   {
	  Object obj=null;
	  long start=System.currentTimeMillis();
	  System.out.println("호출 메소드:"+jp.getSignature().getName());
	  obj=jp.proceed(); 
	  long end=System.currentTimeMillis();
	  System.out.println("수행시간:"+(end-start));
	  return obj;
   }
   @AfterReturning(value = "execution(* com.sist.web.*Controller.*(..))",returning = "obj")
   public void afterReturning(Object obj)
   {
	   if(obj!=null)
	   {
		   String path=(String)obj;
		   System.out.println("호출된 JSP:"+path);
		   
	   }
   }
   // => ControllerAdvice: Controller예외처리를 공통으로 처리
   
}








