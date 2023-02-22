package com.zos.config;

import java.io.IOException;
import java.util.Date;

import javax.crypto.SecretKey;


import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtGenratorFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		SecretKey key=Keys.hmacShaKeyFor(SecurityConstant.JWT_KEY.getBytes());
		
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		
		String jwt=Jwts.builder()
				.setIssuer("zos academy")
				.setSubject("jwt_token")
				.claim("username",authentication.getName())
				.claim("authorities",authentication.getAuthorities())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime()+ 48900000))
				.signWith(key).compact();
		
		
		response.setHeader(SecurityConstant.HEADER, jwt);
		
		
		filterChain.doFilter(request, response);
	}
	
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		return request.getServletPath().equals("/signin");
//		return false;
	}

}
