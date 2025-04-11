package com.sist.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RestController
public class FoodRestController {
  @PostMapping("food/vue_check2_vue.do")
  public Map vue_check(String ss,String[] f)
  {
	  System.out.println("ss:"+ss);
	  Map map=new HashMap();
	  map.put("f", f);
	  return map;
  }
}
