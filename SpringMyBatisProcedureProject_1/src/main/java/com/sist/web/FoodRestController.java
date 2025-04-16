package com.sist.web;
import com.sist.dao.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
@RestController
@CrossOrigin(origins = "*")
public class FoodRestController {
   @Autowired
   private FoodDAO2 dao;
   
   @GetMapping("food/list_vue.do")
   public Map food_list(int page)
   {
	   int rowSize=12;
	   int start=(rowSize*page)-(rowSize-1);
	   int end=(rowSize*page);
	   Map map=new HashMap();
	   map.put("pStart", start);
	   map.put("pEnd", end);
	   List<FoodVO> list=dao.foodListData(map);
	   int totalpage=dao.foodTotalPage();
	   
	   map=new HashMap();
	   map.put("curpage", page);
	   map.put("totalpage", totalpage);
	   map.put("list", list);
	   
	   return map;
   }
}
