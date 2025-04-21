package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.service.*;
import com.sist.vo.*;
@RestController
public class BusanInfoRestController {
   @Autowired
   private BusanInfoService service;
   
   @GetMapping("busan/info_vue.do")
   public Map busan_info(int page,int cno)
   {
	   // 데이터베이스에 설정할 변수 
	   Map map=new HashMap();
	   map.put("cno",cno);
	   map.put("start", (page-1)*12);
	   map.put("end", (page*12));
	   
	   List<BusanInfoVO> list=service.busanInfoListData(map);
	   int totalpage=service.busanInfoTotalPage(cno);
	   
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
	   
	   return map;
	   
   }
}
