package com.example.exercise.service.impl;

import com.example.exercise.data.handler.UserDataHandler;
import com.example.exercise.repository.UserRepository;
import com.example.exercise.dto.UserDto;
import org.springframework.stereotype.Service;
import com.example.exercise.model.entity.User;
import com.example.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {
     
     UserDataHandler userDataHandler;
     
     UserRepository userRepository;
     
     @Autowired
     public UserServiceImpl(UserDataHandler userDataHandler) {
          this.userDataHandler = userDataHandler;
     }
     
     @Autowired
     public void UserDAOImpl(UserRepository userRepository) {
          this.userRepository = userRepository;
     }
     
     @Override
     public UserDto saveUser(String username, String password, Boolean male, String role, int height, int weight) {
          User user = userRepository.findByUsername(username);
          if (user != null) {
               throw new RuntimeException("기존의 있는 유저입니다.");
          } else {
               User userNew = userDataHandler.saveUserEntity(username, password, male, role, height, weight);
               return new UserDto(userNew.getUsername(), userNew.getPassword(), userNew.isMale(), userNew.getRole(), userNew.getHeight(), userNew.getWeight(), userNew.getCreatedAt(), userNew.getUpdateAt());
          }
     }
     
     @Override
     public Boolean login(String username, String password) {
          return userDataHandler.loginUserEntity(username, password);
     }
}
