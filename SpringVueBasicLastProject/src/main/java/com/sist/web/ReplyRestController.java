package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
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
}
