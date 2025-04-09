package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;
@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO dao;
	private String[] types={
	   "","한식","중식","양식","일식"
	};
	
	@GetMapping(value="food/list_vue.do",
		    produces ="text/plain;charset=UTF-8")
	public String food_list(int page ,int type)
	throws Exception
	{
		 int rowSize=12;
		   int start=(rowSize*page)-(rowSize-1);
		   int end=rowSize*page;
		   
		   Map map=new HashMap();
		   // #{start} ${table_name}
		   map.put("type", types[type]);
		   map.put("start", start);
		   map.put("end", end);
		   
		   List<FoodVO> list=dao.foodListData(map);
		   int totalpage=dao.foodTotalPage(map);
		   
		   final int BLOCK=10;
		   int startPage=((page-1)/BLOCK*BLOCK)+1;
		   // 1~10 => 1,11,21....
		   int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		   // 10,20,30....
		   if(endPage>totalpage)
			   endPage=totalpage;
		   
		   // Vue => 출력할 데이터 전송 
		   // => JSON
		   map=new HashMap();
		   map.put("curpage", page);
		   map.put("totalpage", totalpage);
		   map.put("startPage", startPage);
		   map.put("endPage", endPage);
		   map.put("list", list);
		   map.put("title", types[type]);
		   
		   ObjectMapper mapper=new ObjectMapper();
		   String json=mapper.writeValueAsString(map);
		   
		   return json;
	}
}
