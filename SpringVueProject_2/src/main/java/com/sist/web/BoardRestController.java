package com.sist.web;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.sist.dao.*;
@RestController
public class BoardRestController {
  @GetMapping("/board/list_vue/{page}")
  public ResponseEntity<Map> board_list(
		  @PathVariable("page") int page)
  {
	   System.out.println("접근 1");
	   Map map=new HashMap();
	   try
	   {
	      map.put("msg", "PathVariable를 이용한 게시판");
	   }catch(Exception ex)
	   {
		   return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   return new ResponseEntity<>(map,HttpStatus.OK);
	   
  }
}
