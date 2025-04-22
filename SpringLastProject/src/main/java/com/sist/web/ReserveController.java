package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReserveController {
  @GetMapping("reserve/main.do")
  public String reserve_main(Model model)
  {
	  model.addAttribute("main_jsp", "../reserve/reserve_main.jsp");
	  return "main/main";
  }
}
