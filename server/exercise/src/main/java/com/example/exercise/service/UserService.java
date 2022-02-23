package com.example.exercise.service;

import com.example.exercise.dto.UserDto;

public interface UserService {
     
     UserDto saveUser(String username, String password, Boolean male, String role, int height, int weight);
     
     Boolean login(String username, String password);
}
