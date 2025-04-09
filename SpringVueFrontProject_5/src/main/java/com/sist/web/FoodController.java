package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {
	   @GetMapping("food/list.do")
	   public String food_list()
	   {
		   return "food/list";
	   }
	   @GetMapping("food/detail.do")
	   public String food_detail()
	   {
		   return "food/detail";
	   }
}
