package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
   @GetMapping("chat/chat.do")
   public String chat_chat() {
	   System.out.println("chat폼");
	   return "chat/chat";
   }
}
