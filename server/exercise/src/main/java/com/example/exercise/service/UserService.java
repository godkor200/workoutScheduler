package com.example.exercise.service;

import com.example.exercise.dto.UserDto;
import com.example.exercise.model.entity.User;

public interface UserService {
     
     User findUserDetail(String username);
     
     UserDto saveUser(String username, String password, Boolean male, String role, int height, int weight);
     
     Boolean login(String username, String password);
}
