package com.example.exercise.service.impl;

import com.example.exercise.dao.UserDAO;
import com.example.exercise.dto.UserIdPwDto;
import com.example.exercise.repository.UserRepository;
import com.example.exercise.dto.UserDto;
import org.springframework.stereotype.Service;
import com.example.exercise.model.entity.User;
import com.example.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {
     
     
     UserRepository userRepository;
     
     UserDAO userDAO;
     
     
     @Autowired
     public void UserDAOImpl(UserRepository userRepository, UserDAO userDAO) {
          this.userRepository = userRepository;
          this.userDAO = userDAO;
     }
     
     @Override
     public User findUserDetail(String username) {
          return userRepository.findByUsername(username);
     }
     
     @Override
     public User saveUser(UserDto userDto) {
          return userDAO.saveUser(userDto.getUsername(), userDto.getPassword(), userDto.isMale(), userDto.getRole(), userDto.getHeight(), userDto.getWeight());
     }
     
     @Override
     public Boolean login(UserIdPwDto userIdPwDto) {
          User user = userRepository.findByUsername(userIdPwDto.getUsername());
          if (user == null) {
               return null;
          }
          return userDAO.matchPw(userIdPwDto.getUsername(), userIdPwDto.getPassword());
     }
}
