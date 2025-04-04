package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
// 자바스크립트 연동 / 자바스크립트 소스 전송 
@RestController
public class BoardRestController {
   @Autowired
   private BoardDAO dao; // 스프링에서 객체 관리 => 관리하는 객체 주소 주입 
   // => 싱글턴 => 메모리 주소를 한개만 사용 
   // DispatcherServlet => *.do
   @PostMapping(value="board/update_ok.do",produces = "text/html;charset=UTF-8")
   public String board_update_ok(BoardVO vo)
   {
	   String result="";
	   boolean bCheck=dao.boardUpdate(vo);
	   if(bCheck==true)
	   {
		  result="<script>location.href=\"../board/detail.do?no="+vo.getNo()+"\";</script>";   
	   }
	   else
	   {
		   result="<script>"
				 +"alert(\"비밀번호가 틀립니다\");"
				 +"history.back();"
				 +"</script>";
	   }
	   return result;
   }
   
   @PostMapping("board/delete_ok.do")
   public String board_delete(int no,String pwd)
   {
	   String result="";
	   boolean bCheck=dao.boardDelete(no, pwd);
	   if(bCheck==true)
	   {
		  result="<script>location.href=\"../board/list.do\";</script>";   
	   }
	   else
	   {
		   result="<script>"
				 +"alert(\"비밀번호가 틀립니다\");"
				 +"history.back();"
				 +"</script>";
	   }
	   return result;
   }
   
   
}
