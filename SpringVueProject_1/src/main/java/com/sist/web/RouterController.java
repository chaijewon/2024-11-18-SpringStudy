package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouterController {
   @GetMapping("main/main.do")
   public String main_main(Model model)
   {
	   model.addAttribute("main_jsp", "../recipe/list.jsp");
	   return "main/main";
   }
   @GetMapping("recipe/detail.do")
   public String recipe_detail(int no,Model model)
   {
	   model.addAttribute("no", no);
	   model.addAttribute("main_jsp", "../recipe/detail.jsp");
	   return "main/main";
   }
   @GetMapping("food/list.do")
   public String food_list(Model model)
   {
	   model.addAttribute("main_jsp", "../food/list.jsp");
	   return "main/main";
   }
   @GetMapping("food/detail.do")
   public String food_detail(int fno,Model model)
   {
	   model.addAttribute("fno", fno);
	   model.addAttribute("main_jsp", "../food/detail.jsp");
	   return "main/main";
   }
}
