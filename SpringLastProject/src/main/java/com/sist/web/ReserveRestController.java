package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.service.*;
import com.sist.vo.*;

@RestController
public class ReserveRestController {
   @Autowired
   private ReserveService service;
   
   @GetMapping("reserve/main_vue.do")
   public Map reserve_main()
   {
	   Map map=new HashMap();
	   List<FoodVO> list=service.busanFoodReserveData();
	   map.put("list", list);
	   // => 시간 
	   // => 인원 
	   return map;
   }
}
