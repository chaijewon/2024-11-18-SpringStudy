package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

import java.util.*;
@RestController
public class FoodRestController {
   @Autowired
   private FoodDAO dao;
  /*@PostMapping("food/vue_check2_vue.do")
  public Map vue_check(String ss,String[] f)
  {
	  System.out.println("ss:"+ss);
	  Map map=new HashMap();
	  map.put("f", f);
	  return map;
  }*/
	@PostMapping("food/list_vue.do")
	public List<FoodVO> food_list(int page,String[] ss,String fd)
	{
		Map map=new HashMap();
		map.put("fdArr", ss);
		map.put("ss", fd);
		map.put("start", (page*12)-11);
		map.put("end", page*12);
		
		List<FoodVO> list=dao.foodFindData(map);
		return list;
	}
}
