package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;

import co.elastic.clients.elasticsearch.security.get_role.Role;

import com.sist.service.*;
// JSP로 요청 처리 결과값 전송 
@Controller
@RequestMapping("food/")
// food_list.do?page=1
public class FoodRecipeController {
   @Autowired
   private FoodRecipeService service;
   
   // 목록 => 405
   /*
    *   404 파일 찾기 오류 
    *   405 GET/POST
    *   500 DB
    *   400 Bad Request  
    */
   @GetMapping("food_list.do") // Target : Method
   public String food_list(String page,Model model)
   {
	   // 처음 => null값 포함 => 매개변수 => String으로 받는다
	   if(page==null)
		   page="1";
	   
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=12;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   map.put("start", start);
	   map.put("end", end);
	   
	   List<FoodVO> list=service.foodListData(map);
	   int totalpage=service.foodTotalPage();
	   
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   // 1(1~10) 11 21...
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   // 10 20 ...
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   // food_list로 전송 
	   model.addAttribute("list", list);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   return "food/food_list";
   }
   // 쿠키
   @GetMapping("food_detail_before.do")
   public String food_detail_before(String fno,
		   HttpServletResponse response,RedirectAttributes ra)
   {
	   Cookie cookie=new Cookie("spring_"+fno, 
			   fno);
	   cookie.setPath("/");
	   cookie.setMaxAge(60*60*24);
	   response.addCookie(cookie);
	   
	   ra.addAttribute("fno", fno);// sendRedirect
	   // ?대신 사용
	   return "redirect:food_detail.do";
   }
   // 상세보기 
   @GetMapping("food_detail.do")
   public String food_detail(int fno,Model model)
   {
	   FoodVO vo=service.foodDetailData(fno);
	   model.addAttribute("vo", vo);
	   return "food/food_detail";
   }
}
