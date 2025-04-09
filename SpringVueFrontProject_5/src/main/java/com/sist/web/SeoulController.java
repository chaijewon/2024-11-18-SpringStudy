package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// 화면만 변경 => forward / redirect 
public class SeoulController {
   @GetMapping("seoul/list.do")
   public String seoul_list()
   {
	   return "seoul/list";
   }
   @GetMapping("seoul/detail.do")
   public String seoul_detail()
   {
	   return "seoul/detail";
   }
}
