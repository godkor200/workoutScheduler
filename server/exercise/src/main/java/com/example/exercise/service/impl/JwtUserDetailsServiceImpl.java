package com.example.exercise.service.impl;

import com.example.exercise.model.entity.User;
import com.example.exercise.repository.UserRepository;
import com.example.exercise.util.Jwt.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
     
     @Autowired
     private UserRepository userRepository;
     
     @Override
     @Transactional
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          User user = userRepository.findByUsername(username);
          if (user != null) return new JwtUserDetails(user);
          throw new UsernameNotFoundException("Could not find user with user : " + username);
     }
}
