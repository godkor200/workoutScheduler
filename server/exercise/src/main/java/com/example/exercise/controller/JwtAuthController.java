package com.example.exercise.controller;

import com.example.exercise.service.impl.JwtUserDetailsServiceImpl;
import com.example.exercise.util.JwtRequest;
import com.example.exercise.util.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtAuthController {
     
     private AuthenticationManager authenticationManager;
     
     private JwtTokenUtil jwtTokenUtil;
     
     private JwtUserDetailsServiceImpl userDetailsService;
     
     @PostMapping("/api/v1/authenticate")
     public String createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
          System.out.println(authenticationRequest + "authenticationRequest");
          authenticate(authenticationRequest.getUsername(), authenticationRequest.getUsername());
          final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
          return jwtTokenUtil.generateToken(authenticationRequest.getUsername());
     }
     
     private void authenticate(String username, String password) throws Exception {
          try {
               Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
               SecurityContextHolder.getContext()
                                    .setAuthentication(authentication);
               System.out.println(authentication.getAuthorities()
                                                .toString());
          } catch (DisabledException e) {
               throw new Exception("USER_DISABLED", e);
          } catch (BadCredentialsException e) {
               throw new Exception("INVALID_CREDENTIALS", e);
          }
     }
}
