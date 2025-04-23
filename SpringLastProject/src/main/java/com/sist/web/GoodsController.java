package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodsController {
   @GetMapping("goods/list.do")
   /*
    *   <a> location.href=""
    *   axios.get ==> vue / react 
    *                 ----------- fetch
    *   $.ajax({
    *      type:get
    *   })
    *   => default 
    *   
    *   <form> axios.post 
    *   $.ajax({
    *     type:post
    *   })
    */
   public String goods_list(Model model)
   {
	   model.addAttribute("main_jsp", "../goods/list.jsp");
	   return "main/main";
   }
}
