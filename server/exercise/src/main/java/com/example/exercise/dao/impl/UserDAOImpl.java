package com.example.exercise.dao.impl;

import com.example.exercise.dao.UserDAO;
import com.example.exercise.model.entity.User;
import org.springframework.stereotype.Service;
import com.example.exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserDAOImpl implements UserDAO {
     
     UserRepository userRepository;
     
     @Autowired
     public UserDAOImpl(UserRepository userRepository) {
          this.userRepository = userRepository;
     }
     
     @Override
     public User saveUser(User user) {
          userRepository.save(user);
          return user;
     }
     
     @Override
     public Boolean matchPw(String username, String password) {
          User user = userRepository.findByUsername(username);
          System.out.println(user);
          return user.getPassword()
                     .equals(password);
     }
}
