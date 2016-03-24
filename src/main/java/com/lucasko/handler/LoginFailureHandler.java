package com.lucasko.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

@Service
public class LoginFailureHandler implements AuthenticationFailureHandler {

	private static final Logger logger = Logger.getLogger(LoginFailureHandler.class);

	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException ae) throws IOException, ServletException {
		try {
			UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) ae.getAuthentication();
			logger.warn("username=" + token.getName());
			logger.warn("password=" + token.getCredentials());
			logger.warn("ip address=" + request.getRemoteAddr() + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("login?error");
	}
}