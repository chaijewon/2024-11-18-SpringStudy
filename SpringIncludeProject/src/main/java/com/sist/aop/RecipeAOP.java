package com.sist.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect // 메모리 할당 (X) => 공동 모듈 
@Component
// request : @Controller , @RestController 
// Interceptor
public class RecipeAOP {
   @After("execution(* com.sist.web.*Controller.*(..))")
   public void after()
   {
	   // 현재 사용중인 request를 가지고 온다 
	   HttpServletRequest request=
			((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
   }
}
