package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 *   동작 순서  => 폴더 http://localhost:8080/web/board/list.do
 *   -------
 *                       Controller
 *   사용자 요청 (.do) == DispatcherServlet
 *                           |
 *                      Model 찾기 (@RequestMapping) : HandlerMapping
 *                           | request  
 *                         Model 처리 => 메소드 호출 
 *                           |
 *                         JSP 찾기 : ViewResolver  => 경로명 / 확장자 
 *                                   p:prefix="/"
                                     p:suffix=".jsp"
 *                           | => request 전송
 *                          JSP
 *              HandlerMapping => DispatcherServlet    
 */
@Controller
public class BoardModel {
   @RequestMapping("board/list.do")
   public String board_list(HttpServletRequest request,
		   HttpServletResponse response)
   {
	   String msg="Hello Spring MVC!!";
	   request.setAttribute("msg", msg);
	   return "board/list"; // .jsp(X) 
   }
}
