package com.lucasko.handler;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

@Service
public class LoginSucessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private static final Logger logger = Logger.getLogger(LoginSucessHandler.class);
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		String targetUrl = "";
		logger.info("username=" + authentication.getName());
		logger.info("ip address=" + request.getRemoteAddr());

		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

		if (roles.contains("ROLE_ADMIN")) {
			logger.info("role=ROLE_ADMIN \n");
			targetUrl = "/admin";
		} else {
			logger.info("role=ROLE_USER \n");
			targetUrl = "/user";
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);

	}

}