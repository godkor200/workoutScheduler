package com.example.exercise.data.handler.impl;

import com.example.exercise.dao.UserDAO;
import com.example.exercise.data.handler.UserDataHandler;
import com.example.exercise.model.entity.User;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserDataHandlerImpl implements UserDataHandler {
     
     UserDAO userDAO;
     
     @Autowired
     public UserDataHandlerImpl(UserDAO userDAO) {
          this.userDAO = userDAO;
     }
     
     @Override
     public User saveUserEntity(String username, String password, Boolean male, String role, int height,
                                int weight) {
//          String pw = passwordEncoder.encode(password);
          System.out.println(password);
          User user = new User(username, password, male, height, weight, role);
          return userDAO.saveUser(user);
     }
     
     @Override
     public boolean loginUserEntity(String username, String password) {
          return userDAO.matchPw(username, password);
     }
     
}
