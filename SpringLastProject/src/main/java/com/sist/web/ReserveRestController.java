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
	   List<String> tList=new ArrayList<String>();
	   tList.add("17:00");
	   tList.add("18:00");
	   tList.add("19:00");
	   tList.add("20:00");
	   tList.add("21:00");
	   tList.add("22:00");
	   tList.add("23:00");
	   tList.add("24:00");
	   map.put("time", tList);
	   // => 인원 
	   List<String> iList=new ArrayList<String>();
	   for(int i=1;i<=10;i++)
	   {
		   iList.add(String.valueOf(i));
	   }
	   iList.add("단체");
	   map.put("inwon", iList);
	   return map;
   }
}
