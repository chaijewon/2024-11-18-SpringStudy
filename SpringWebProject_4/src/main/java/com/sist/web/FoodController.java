package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {
   @GetMapping("food2/food_list.do")
   public String food_list()
   {
	   return "food2/food_list";
   }
   @GetMapping("food2/food_detail.do")
   public String food_detail(int fno,Model model)
   {
	   model.addAttribute("fno", fno);
	   return "food2/food_detail";
   }
}
