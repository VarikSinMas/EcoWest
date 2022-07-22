package com.example.eco.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.eco.UsuarioServices.CustomUsuarioDetailsService;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

	@Autowired
	private CustomUsuarioDetailsService customUsuarioDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil; 
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String requestTokenHeader = request.getHeader("Authorization");

		String nickname = null;
		String jwtToken = null;
		//pñ (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer")) {
		if (requestTokenHeader != null ) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				nickname = jwtTokenUtil.getNicknameFromToken(requestTokenHeader);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		} else {
			logger.warn("No hay ningun token generado, prosigan");
		}

		// Once we get the token validate it.
		if (nickname != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			 
			 UserDetails userDetails = this.customUsuarioDetailsService.loadUserByUsername(nickname);

			// if token is valid configure Spring Security to manually set
			// authentication
			if (jwtTokenUtil.validateToken(requestTokenHeader, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the
				// Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
		
	}

}
