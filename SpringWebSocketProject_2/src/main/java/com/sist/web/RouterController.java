package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouterController {
   @GetMapping("member/login.do")
   public String member_login()
   {
	   return "member/login";
   }
   @GetMapping("chat/chat.do")
   public String chat_chat()
   {
	   return "site/chat/chat";
   }
}
