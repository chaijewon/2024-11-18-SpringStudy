package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.sist.dao.*;
@RestController
public class BoardRestController {
  @Autowired
  private BoardDAO dao;
  
  @GetMapping("/board/list_vue/{page}")
  public ResponseEntity<Map> board_list(
		  @PathVariable("page") int page)
  {
	   System.out.println("접근 1");
	   Map map=new HashMap();
	   try
	   {
	       int rowSize=10;
	       int start=(page-1)*rowSize;
	       int end=rowSize*page;
	       map.put("start", start);
	       map.put("end", end);
	       
	       List<BoardVO> list=dao.boardListData(map);
	       int totalpage=dao.boardTotalPage();
	       
	       map=new HashMap();
		   map.put("msg", "PathVariable를 이용한 게시판");
		   map.put("curpage", page);
		   map.put("totalpage", totalpage);
		   map.put("list", list);
	   }catch(Exception ex)
	   {
		   return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   return new ResponseEntity<>(map,HttpStatus.OK);
	   
  }
}
