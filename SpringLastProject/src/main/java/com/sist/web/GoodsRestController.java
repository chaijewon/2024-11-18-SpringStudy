package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.service.*;
import com.sist.vo.*;
@RestController
public class GoodsRestController {
  @Autowired
  private GoodsService service;
  
  @GetMapping("goods/list_vue.do")
  public Map food_list(int page)
  {
	   int rowSize=12;
	   List<GoodsVO> list=
		 service.busanGoodsListData((page*rowSize)-(rowSize-1), page*rowSize);
	   int totalpage=service.busanGoodsTotalPage();
	   
	   final int BLOCK=10;
	   int startPage=((page-1)/BLOCK*BLOCK)+1;
	   int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	   
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   // Vue로 전송 
	   Map map=new HashMap();
	   map.put("list", list);
	   map.put("curpage", page);
	   map.put("totalpage", totalpage);
	   map.put("startPage", startPage);
	   map.put("endPage", endPage);
	   
	   return map;
  }
  @GetMapping("goods/detail_vue.do")
  public GoodsVO goods_detail(int no)
  {
	  GoodsVO vo=service.busanGoodsDetailData(no);
	  return vo;
  }
  // 다른 프로그램과 연동 => 요청 데이터 전송 
  // <script> => 크롬 / FF
  @PostMapping("goods/cart_insert.do")
  public String cart_insert(int gno,int account,
		  HttpSession session)
  {
	  String result="";
	  String userid=(String)session.getAttribute("userid");
	  CartVO vo=new CartVO();
	  vo.setAccount(account);
	  vo.setUserid(userid);
	  vo.setGno(gno);
	  try
	  {
		  service.goodsCartInsert(vo);
		  result="yes";
	  }catch(Exception ex)
	  {
		  result=ex.getMessage();  
	  }
	  return result;
  }
  @GetMapping("goods/buy_vue.do")
  public String goods_buy(int cno)
  {
	  String result="";
	  try
	  {
		  result="yes";
		  service.goodsBuyUpdate(cno);
	  }catch(Exception ex)
	  {
		  result="no";  
	  }
	  return  result;
  }
}
