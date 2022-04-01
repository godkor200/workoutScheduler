package com.example.exercise.util.Jwt;

import com.example.exercise.service.impl.JwtUserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
     
     @Autowired
     private JwtUserDetailsServiceImpl jwtUserDetailsService;
     
     @Autowired
     private JwtTokenUtil jwtTokenUtil;
     
     @Override
     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
          
          final String reqTokenHeader = request.getHeader("Authorization");
          System.out.println(reqTokenHeader);
          String username = null;
          String jwtToken = null;
          
          if (reqTokenHeader != null && reqTokenHeader.startsWith("Bearer")) {
               
               jwtToken = reqTokenHeader.substring(7);
               
               try {
                    username = jwtTokenUtil.getUsernameFromToken(jwtToken);
               } catch (IllegalArgumentException e) {
                    System.out.println("Unable to get JWT Token");
               } catch (ExpiredJwtException e) {
                    System.out.println("JWT Token has expired");
               }
          } else {
               logger.warn("JWT Token does not begin with Bearer String");
          }
          if (username != null && SecurityContextHolder.getContext()
                                                       .getAuthentication() == null) {
               UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
               
               if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext()
                                         .setAuthentication(usernamePasswordAuthenticationToken);
               }
          }
          //토큰이 없을 경우
          chain.doFilter(request, response);
     }
}
