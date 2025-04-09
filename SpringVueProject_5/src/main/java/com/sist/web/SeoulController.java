package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SeoulController {
   @GetMapping("seoul/seoul_list.do")
   public String seoul_list()
   {
	   return "seoul/seoul_list";
   }
}
