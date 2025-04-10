package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 화면 변경
@Controller
public class DataBoardController {
   @GetMapping("databoard/list.do")
   public String databoard_list()
   {
	   return "databoard/list";
   }
   @GetMapping("databoard/insert.do")
   public String databoard_insert()
   {
	   return "databoard/insert";
   }
   @GetMapping("databoard/detail.do")
   public String databoard_detail()
   {
	   return "databoard/detail";
   }
}
