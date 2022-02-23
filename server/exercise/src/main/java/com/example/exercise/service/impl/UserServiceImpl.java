package com.example.exercise.service.impl;

import com.example.exercise.data.handler.UserDataHandler;
import com.example.exercise.dto.UserDto;
import org.springframework.stereotype.Service;
import com.example.exercise.model.entity.User;
import com.example.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {
     
     UserDataHandler userDataHandler;
     
     @Autowired
     public UserServiceImpl(UserDataHandler userDataHandler) {
          this.userDataHandler = userDataHandler;
     }
     
     @Override
     public UserDto saveUser(String username, String password, Boolean male, String role, int height, int weight) {
          User user = userDataHandler.saveUserEntity(username, password, male, role, height, weight);
          
          return new UserDto(user.getUsername(), user.getPassword(), user.isMale(), user.getRole(), user.getHeight(), user.getWeight(), user.getCreatedAt(), user.getUpdateAt());
     }
     
     @Override
     public Boolean login(String username, String password) {
          System.out.println(username + password);
          return userDataHandler.loginUserEntity(username, password);
     }
}
