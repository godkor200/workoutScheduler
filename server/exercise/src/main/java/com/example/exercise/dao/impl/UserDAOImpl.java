package com.example.exercise.dao.impl;

import com.example.exercise.dao.UserDAO;
import com.example.exercise.model.entity.User;
import org.springframework.stereotype.Service;
import com.example.exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Service
public class UserDAOImpl implements UserDAO {
     
     UserRepository userRepository;
     
     @Autowired
     public UserDAOImpl(UserRepository userRepository) {
          this.userRepository = userRepository;
     }
     
     @Override
     public User saveUser(String username, String password, Boolean male, String role, int height,
                          int weight) {
          LocalDateTime currentTime = LocalDateTime.now();
          User user = new User(username, password, male, height, weight, role, currentTime);
          userRepository.save(user);
          return user;
     }
     
     @Override
     public Boolean matchPw(String username, String password) {
          User user = userRepository.findByUsername(username);
          if (user == null) return null;
          return user.getPassword()
                     .equals(password);
     }
}
