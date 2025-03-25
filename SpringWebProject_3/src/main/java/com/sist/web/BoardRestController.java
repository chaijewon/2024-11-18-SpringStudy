package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;
import com.sist.vo.*;
// @ResponseBody => 메소드 => Class형태로 변경 => Ajax / Vue / React연동
@RestController // 화면이동이 아니라 보통 데이터 전송 
// => 자바스크립트 전송이 가능 => JSON / JavaScript ..
public class BoardRestController {
	@Autowired
    private BoardDAO dao;
	
	@RequestMapping(value = "board/update_ok.do",produces = "text/html;charset=UTF-8")
	public String board_update_ok(BoardVO vo)
	{
		String result="";
		boolean bCheck=dao.boardUpdate(vo);
		if(bCheck==true)
		{
		    result="<script>"
		          +"location.href=\"detail.do?no="+vo.getNo()+"\""
		          +"</script>";
		}
		else
		{
			result="<script>"
				  +"alert(\"비밀번호가 틀립니다!!\");"
				  +"history.back();"
				  +"</script>";
				  
		}
		return result;
	}
	@RequestMapping(value="board/delete_ok.do",produces = "text/html;charset=UTF-8")
	public String board_delete_ok(int no,String pwd)
	{
		String result="";
		boolean bCheck=dao.boardDelete(no, pwd);
		if(bCheck==true)
		{
		    result="<script>"
		          +"location.href=\"list.do\""
		          +"</script>";
		}
		else
		{
			result="<script>"
				  +"alert(\"비밀번호가 틀립니다!!\");"
				  +"history.back();"
				  +"</script>";
				  
		}
		return result;
	}
}
