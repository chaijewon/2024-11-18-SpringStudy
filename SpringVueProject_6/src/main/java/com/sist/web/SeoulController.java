package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SeoulController {
   @GetMapping("seoul/list.do")
   public String seoul_list() {
	   return "seoul/list";
   }
}
