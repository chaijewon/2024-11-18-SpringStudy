package com.sist.web;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.service.*;
import com.sist.vo.*;
@Controller
@RequestMapping("food/")
public class FoodController {
  @GetMapping("list.do")
  public String food_list(Model model)
  {
	  model.addAttribute("main_jsp", "../food/list.jsp");
	  return "main/main";
  }
}
