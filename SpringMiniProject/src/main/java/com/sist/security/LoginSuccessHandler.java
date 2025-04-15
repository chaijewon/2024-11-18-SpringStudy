package com.sist.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.sist.vo.*;

import lombok.Setter;

public class LoginSuccessHandler implements AuthenticationSuccessHandler{
    @Setter
	private String defaultUrl;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		session.setAttribute("mvo", authentication.getPrincipal());
		response.sendRedirect("../main/main.do");
	}

}
