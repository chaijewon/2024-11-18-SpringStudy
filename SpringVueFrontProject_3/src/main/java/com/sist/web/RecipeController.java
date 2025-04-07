package com.sist.web;

import org.springframework.stereotype.Controller;
// 화면 변경용 
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class RecipeController {
   @GetMapping("recipe/list.do")
   public String recipe_list()
   {
	   return "recipe/list";
   }
}
