package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.dao.*;
import com.sist.vo.*;
@RestController
public class ReplyRestController {
   @Autowired
   private ReplyDAO dao;
   
   public List<ReplyVO> replyListData(int bno)
   {
	   List<ReplyVO> list=dao.replyListData(bno);
	   
	   return list;
   }
   
   @GetMapping("reply/list_vue.do")
   public List<ReplyVO> replyData(int bno)
   {
	   return replyListData(bno);
   }
   // #{bno},#{id},#{name},#{msg}
   @PostMapping("reply/insert_vue.do")
   public List<ReplyVO> replyInsert(ReplyVO vo,
		   HttpSession session)
   {
	   System.out.println("bno:"+vo.getBno());
	   System.out.println("msg:"+vo.getMsg());
	   String id=(String)session.getAttribute("id");
	   String name=(String)session.getAttribute("name");
	   vo.setId(id);
	   vo.setName(name);
	   
	   dao.replyInsert(vo);
	   
	   return replyListData(vo.getBno());
   }
}
