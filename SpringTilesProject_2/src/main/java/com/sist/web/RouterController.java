package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// 화면 변경 => 출력 / VueJS
@Controller
public class RouterController {
  @GetMapping("main/main.do")
  public String main_main()
  {
	  return "main";
  }
}
