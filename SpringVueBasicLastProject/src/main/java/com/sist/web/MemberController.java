package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

@Controller
public class MemberController {
   @Autowired
   private MemberDAO dao;
   
   @GetMapping("member/login.do")
   public String member_login()
   {
	   return "member/login";
   }
   @PostMapping("member/login_ok.do")
   public String member_login_ok(String id,String pwd,
		   HttpSession session,Model model)
   {
	   MemberVO vo=dao.memberGetInfoData(id, pwd);
	   if(vo.getMsg().equals("OK"))
	   {
		   session.setAttribute("id", vo.getId());
		   session.setAttribute("name", vo.getName());
		   session.setAttribute("sex", vo.getSex());
	   }
	   
	   model.addAttribute("msg", vo.getMsg());
	   
	   return "member/login_ok";
   }
}
