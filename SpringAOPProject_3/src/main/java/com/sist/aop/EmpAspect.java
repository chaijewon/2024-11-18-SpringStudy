package com.sist.aop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/*
 *   <aop:aspect ref="aspect">
        <aop:before method="before"
          pointcut="execution(* com.sist.dao.EmpDAO.emp*(..))"
        />
        <aop:after method="after"
          pointcut="execution(* com.sist.dao.EmpDAO.emp*(..))"
        />
        <aop:after-returning method="afterReturning"
          pointcut="execution(* com.sist.dao.EmpDAO.emp*(..))"
          returning="obj"
        />
        <aop:after-throwing method="afterThrowing"
          pointcut="execution(* com.sist.dao.EmpDAO.emp*(..))"
          throwing="ex"
        />
        <aop:around method="around"
          pointcut="execution(* com.sist.dao.EmpDAO.emp*(..))"
        />
      </aop:aspect>
 */
import com.sist.dao.*;
@Aspect // 메모리 할당을 할 수 없다 
@Component
public class EmpAspect {
	/*
	 *   <bean id="aspect" class="com.sist.aop.EmpAspect"
		      p:dao-ref="dao"
		    />
	 */
  @Autowired
  private EmpDAO dao;
  
  @Before("execution(* com.sist.dao.EmpDAO.emp*(..))")
  public void before()
  {
	  dao.getConnection();
  }
  @After("execution(* com.sist.dao.EmpDAO.emp*(..))")
  public void after()
  {
	  dao.disConnection();
  }
  @Around("execution(* com.sist.dao.EmpDAO.emp*(..))")
  public Object around(ProceedingJoinPoint jp) throws
  Throwable
  {
	  System.out.println("사용자가 호출한 메소드:"+jp.getSignature().getName());
	  Object obj=null;
	  long start=System.currentTimeMillis();
	  obj=jp.proceed(); // invoke()
	  long end=System.currentTimeMillis();
	  System.out.println("수행 시간 확인:"+(end-start));
	  return obj;
  }
  @AfterReturning(value = "execution(* com.sist.dao.EmpDAO.emp*(..))",returning = "obj")
  public void afterReturning(Object obj)
  {
  	System.out.println("===== 결과값 자동 처리 =====");
  	// => 공통적으로 필요한 request를 전송 => 푸터 
  	List<EmpVO> list=(List<EmpVO>)obj;
  	for(EmpVO vo:list)
  	{
  		System.out.println(vo.getEmpno()+" "
  				+vo.getEname()+" "
  				+vo.getDbday()+" "
  				+vo.getJob()+" "
  				+vo.getSal());
  	}
  }
  @AfterThrowing(value="execution(* com.sist.dao.EmpDAO.emp*(..))",throwing = "ex")
  public void afterThrowing(Throwable ex)
  {
  	System.out.println("======= 에러 발생 ======");
  	ex.printStackTrace();
  	// 공통 에러 처리 
  	// => @ControllerAdvice
  }
}
