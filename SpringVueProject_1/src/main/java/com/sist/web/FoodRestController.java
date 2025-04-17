package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.*;
import com.sist.vo.*;
@RestController
public class FoodRestController {
   @Autowired
   private FoodDAO fDao;
   
   @GetMapping("food/list_vue.do")
   // params => 매개변수 => formData => VO
   public ResponseEntity<Map> food_list(int page)
   {
   	// 에러 / 정상 (status) => 실제 데이터 전송 
   	Map map=new HashMap();
   	try
   	{
   		int rowSize=12;
   		int start=(rowSize*page)-(rowSize-1);
   		int end=rowSize*page;
   		
   		List<FoodVO> list=
   				fDao.foodListData(start, end);
   		int totalpage=fDao.foodTotalPage();
   		final int BLOCK=10;
   		int startPage=((page-1)/BLOCK*BLOCK)+1;
   		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
   		
   		if(endPage>totalpage)
   			endPage=totalpage;
   		// Vue로 전송 
   		map.put("list", list);
   		map.put("curpage", page);
   		map.put("totalpage", totalpage);
   		map.put("startPage", startPage);
   		map.put("endPage", endPage);
   		
   		// {}
   	}catch(Exception ex)
   	{
   		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
   	}
   	return new ResponseEntity<>(map,HttpStatus.OK);
   }
}
