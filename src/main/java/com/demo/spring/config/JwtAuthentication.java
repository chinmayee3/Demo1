package com.demo.spring.config;

import java.io.IOException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.demo.spring.helper.JwtUtil;
import com.demo.spring.service.CustomUserDetailsService;

@Component
public class JwtAuthentication extends OncePerRequestFilter{
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException
	{
			//get jwt
			//Bearer
			//validate
			String requestTokenHeader=request.getHeader("Authorization");
			String username=null;
			String jwtToken=null;
			//null and format
			if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
			{
				jwtToken=requestTokenHeader.substring(7);
				try {
					username=this.jwtUtil.extractUsername(jwtToken);
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				//security
				UserDetails userDetails=this.customUserDetailsService.loadUserByUsername(username);
				if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) 
					{
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
					
					}else{
						System.out.println("Token not valid");
					}
			}
			response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		    response.setHeader("Access-Control-Allow-Credentials", "true");
		    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		    response.setHeader("Access-Control-Max-Age", "3600");
		    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");

			filterChain.doFilter(request, response);
					
			//throws ServletException, IOException {
		// TODO Auto-generated method stub
			
	}

}
