package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.sist.service.*;
@RestController
public class CommentRestController {
   @Autowired
   private CommentService service;
   
   public Map commonsListData(int page,int cno,int type)
   {
	   Map map=new HashMap();
	   // 데이터베이스 연동 
	   int rowSize=10;
	   map.put("start", (page-1)*rowSize);
	   map.put("end", page*rowSize);
	   map.put("cno", cno);
	   map.put("type", type);
	   
	   List<CommentVO> list=service.commentListData(map);
	   int totalpage=service.commentTotalPage(cno, type);
	   
	   final int BLOCK=5;
	   int startPage=((page-1)/BLOCK*BLOCK)+1;
	   int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	   
	   if(endPage>totalpage)
		   endPage=totalpage;
	   // 값 읽기 => JSON으로 전송 Map 
	   map=new HashMap();
	   map.put("list", list);
	   map.put("curpage", page);
	   map.put("totalpage", totalpage);
	   map.put("startPage", startPage);
	   map.put("endPage", endPage);
	   return map;
   }
   
   // 목록 
   @GetMapping("comment/list_vue.do")
   public Map comment_list(int page,int cno,int type)
   {
	   return commonsListData(page, cno, type);
   }
   // 추가 
   @PostMapping("comment/insert_vue.do")
   public Map comment_insert(CommentVO vo,
		   HttpSession session)
   {
	   String userid=(String)session.getAttribute("userid");
	   String username=(String)session.getAttribute("username");
	   String sex=(String)session.getAttribute("sex");
	   vo.setUserid(userid);
	   vo.setUsername(username);
	   vo.setSex(sex);
	   
	   service.commenInsert(vo);
	   
	   return commonsListData(1, vo.getCno(), vo.getType());
	   
   }
   // 수정 
   @PostMapping("comment/update_vue.do")
   public Map comment_update(CommentVO vo)
   {
	   service.commentUpdate(vo.getMsg(), vo.getNo());
	   
	   return commonsListData(1, vo.getCno(), vo.getType());
   }
   // 삭제 
   // 대댓글 
   @PostMapping("comment/reply_insert_vue.do")
   public Map comment_reply_insert(int pno,CommentVO vo,HttpSession session)
   {
	   String userid=(String)session.getAttribute("userid");
	   String username=(String)session.getAttribute("username");
	   String sex=(String)session.getAttribute("sex");
	   vo.setUserid(userid);
	   vo.setUsername(username);
	   vo.setSex(sex);
	   
	   service.commentReplyReplyInsert(pno, vo);
	   
	   return commonsListData(1, vo.getCno(), vo.getType());
   }
   @GetMapping("comment/delete_vue.do")
   public Map comment_delete(CommentVO vo)
   {
	   System.out.println("no:"+vo.getNo());
	   service.commentDelete(vo.getNo());
	   return commonsListData(1, vo.getCno(), vo.getType());
   }
   
}
