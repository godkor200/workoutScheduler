package com.example.exercise.util;

import com.example.exercise.util.Exception.UsernameFromTokenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class ExceptionHandlerFilter extends OncePerRequestFilter {
     
     @Override
     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
          try {
               filterChain.doFilter(request, response);
          } catch (UsernameFromTokenException ex) {
               log.error("exception exception handler filter");
               setErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, response, ex);
          } catch (RuntimeException ex) {
               log.error("runtime exception exception handler filter");
               setErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, response, ex);
          }
     }
     
     public void setErrorResponse(HttpStatus status, HttpServletResponse response, Throwable ex) {
          response.setStatus(status.value());
          response.setContentType("application/json");
          ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTER_SERVER_ERROR);
          errorResponse.setMessage(ex.getMessage());
          
          try {
               String json = errorResponse.getMessage();
               System.out.println(json);
               response.getWriter()
                       .write(json);
          } catch (IOException e) {
               e.printStackTrace();
          }
     }
}
