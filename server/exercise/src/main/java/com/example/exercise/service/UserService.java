package com.example.exercise.service;

import com.example.exercise.dto.UserDto;
import com.example.exercise.dto.UserIdPwDto;
import com.example.exercise.model.entity.User;

public interface UserService {
     
     User findUserDetail(String username);
     
     User saveUser(UserDto userDto);
     
     Boolean login(UserIdPwDto userIdPwDto);
}
