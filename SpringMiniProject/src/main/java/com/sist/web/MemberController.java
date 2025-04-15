package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

@Controller
public class MemberController {
   @Autowired
   private BCryptPasswordEncoder encoder;
   
   @Autowired
   private MemberDAO dao;
   
   @GetMapping("member/join.do")
   public String member_join(Model model)
   {
	   model.addAttribute("main_jsp", 
			        "../member/join.jsp");
	   return "main/main";
   }
   @RequestMapping("member/login.do")
   public String member_login(Model model)
   {
	   model.addAttribute("main_jsp", 
		        "../member/login.jsp");
       return "main/main";
   }
   @PostMapping("member/join_ok.do")
   public String member_join_ok(MemberVO vo)
   {
	   vo.setPhone(vo.getPhone1()+"-"+vo.getPhone2());
	   // 비밀번호 암호화 
	   String enPwd=encoder.encode(vo.getUserpwd());
	   vo.setUserpwd(enPwd);
	   dao.memberInsert(vo);
	   
	   return "redirect:../main/main.do";
   }
}
