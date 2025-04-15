package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
   @GetMapping("member/join.do")
   public String member_join(Model model)
   {
	   model.addAttribute("main_jsp", 
			        "../member/join.jsp");
	   return "main/main";
   }
   @GetMapping("member/login.do")
   public String member_login(Model model)
   {
	   model.addAttribute("main_jsp", 
		        "../member/login.jsp");
       return "main/main";
   }
}
