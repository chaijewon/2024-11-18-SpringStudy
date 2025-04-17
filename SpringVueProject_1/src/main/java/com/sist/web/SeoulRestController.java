package com.sist.web;
import com.sist.dao.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
@RestController
public class SeoulRestController {
  @Autowired
  private SeoulDAO sDao;
  
  @GetMapping("seoul/location_vue.do")
  // params => 매개변수 => formData => VO
  public ResponseEntity<Map> seoul_location(int page)
  {
  	// 에러 / 정상 (status) => 실제 데이터 전송 
  	Map map=new HashMap();
  	try
  	{
  		int rowSize=12;
  		int start=(rowSize*page)-(rowSize-1);
  		int end=rowSize*page;
  		
  		map.put("start", start);
  		map.put("end", end);
  		map.put("table_name", "seoul_location");
  		
  		List<SeoulVO> list=
  				sDao.seoulListData(map);
  		int totalpage=sDao.seoulTotalPage(map);
  		final int BLOCK=10;
  		int startPage=((page-1)/BLOCK*BLOCK)+1;
  		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
  		
  		if(endPage>totalpage)
  			endPage=totalpage;
  		// Vue로 전송 
  		map=new HashMap();
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
  
  @GetMapping("seoul/shop_vue.do")
  // params => 매개변수 => formData => VO
  public ResponseEntity<Map> seoul_shop(int page)
  {
  	// 에러 / 정상 (status) => 실제 데이터 전송 
  	Map map=new HashMap();
  	try
  	{
  		int rowSize=12;
  		int start=(rowSize*page)-(rowSize-1);
  		int end=rowSize*page;
  		
  		map.put("start", start);
  		map.put("end", end);
  		map.put("table_name", "seoul_shop");
  		
  		List<SeoulVO> list=
  				sDao.seoulListData(map);
  		int totalpage=sDao.seoulTotalPage(map);
  		final int BLOCK=10;
  		int startPage=((page-1)/BLOCK*BLOCK)+1;
  		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
  		
  		if(endPage>totalpage)
  			endPage=totalpage;
  		// Vue로 전송 
  		map=new HashMap();
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
