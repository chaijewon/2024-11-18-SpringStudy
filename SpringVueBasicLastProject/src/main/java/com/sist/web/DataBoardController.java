package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
   public String databoard_detail(int no,
		   HttpSession session,Model model)
   {
	   String id=(String)session.getAttribute("id");
	   model.addAttribute("sessionId", id);
	   model.addAttribute("no", no);
	   return "databoard/detail";
   }
}
