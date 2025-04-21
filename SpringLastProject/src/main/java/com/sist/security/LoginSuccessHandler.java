package com.sist.security;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.sist.dao.*;
import com.sist.vo.*;
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private MemberDAO dao;
    // login_ok
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		MemberVO vo=dao.memberInfoData(authentication.getName());
		HttpSession session=request.getSession();
		session.setAttribute("userid", vo.getUserid());
		session.setAttribute("username", vo.getUsername());
		session.setAttribute("sex", vo.getSex());
		
		response.sendRedirect("../main/main.do");
		
	}
}
