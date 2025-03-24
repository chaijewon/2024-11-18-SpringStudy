package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
/*
 *   Mapper => 스프링에서 구현 
 *   --------------------
 *          |
 *       BoardDAO
 *          |
 *       Model => JSP
 */
@Controller  // 화면 변경 => forward / sendRedirect
public class BoardController {
	
	@Autowired
    private BoardDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping("board/list.do")
	public String board_list(String page,Model model)
	{
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		List<BoardVO> list=dao.boardListData((10*curpage)-9, curpage*10);
		int totalpage=dao.boardTotalPage();
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping("board/insert.do")
	public String board_insert()
	{
		return "board/insert";
	}
	@RequestMapping("board/insert_ok.do")
	public String board_insert_ok(BoardVO vo)
	{
		String pwd=encoder.encode(vo.getPwd());
		vo.setPwd(pwd);
		System.out.println("pwd="+pwd);
		dao.boardInsert(vo);
		// => if(pwd.matchs(vo.getPwd())
		
		return "redirect:list.do";
	}
	// 수정 / 삭제 => 비번 검색 
	
}








