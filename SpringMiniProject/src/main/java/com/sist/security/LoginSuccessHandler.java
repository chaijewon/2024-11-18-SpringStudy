package com.sist.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.sist.vo.*;
import com.sist.dao.*;
import lombok.Setter;

public class LoginSuccessHandler implements AuthenticationSuccessHandler{
    @Setter
	private String defaultUrl;
    @Autowired
    private MemberDAO dao;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		MemberVO vo=dao.memberSessionData(authentication.getName());
		//authentication 정보 => username(id) , password , enable
		session.setAttribute("userid", vo.getUserid());
		session.setAttribute("username", vo.getUsername());
		session.setAttribute("sex", vo.getSex());
		response.sendRedirect("../main/main.do");
	}

}
