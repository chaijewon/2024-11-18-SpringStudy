package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.vo.*;
import com.sist.commons.CommonsPagination;
import com.sist.dao.*;
@Controller
public class BoardController {
   @Autowired
   private BoardDAO2 dao;
   
   @GetMapping("board/list.do")
   public String board_list(String page,Model model)
   {
	   Map map=CommonsPagination.pageConfig(page, 10);
	   int curpage=(int)map.get("curpage");
	   List<BoardVO> list=dao.boardListData(map);
	   int count=dao.boardRowCount();
	   int totalpage=(int)(Math.ceil(count/10.0));
	   count=count-((curpage*10)-10);
	   
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
       model.addAttribute("count", count);	   
 	   model.addAttribute("main_jsp", "../replyboard/list.jsp");
	   return "main/main";
   }
   @GetMapping("board/insert.do")
   public String board_insert(Model model)
   {
	   model.addAttribute("main_jsp", "../replyboard/insert.jsp");
	   return "main/main";
   }
   @PostMapping("board/insert_ok.do")
   public String board_insert_ok(BoardVO vo)
   {
	   dao.boardInsert(vo);
	   return "redirect:../board/list.do";
   }
   @GetMapping("board/detail.do")
   public String board_detail(int no,Model model)
   {
	   BoardVO vo=dao.boardDetailData(no);
	   model.addAttribute("vo", vo);
	   model.addAttribute("main_jsp", "../replyboard/detail.jsp");
	   return "main/main";
   }
   /*@GetMapping("board/update.do")
   public String board_update(int no,Model model)
   {
	   BoardVO vo=dao.boardUpdateData(no);
	   model.addAttribute("vo", vo);
	   model.addAttribute("main_jsp", "../replyboard/update.jsp");
	   return "main/main";
   }*/
}
