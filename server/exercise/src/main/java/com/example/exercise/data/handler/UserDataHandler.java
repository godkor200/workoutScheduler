package com.example.exercise.data.handler;

import com.example.exercise.model.entity.User;

public interface UserDataHandler {
     
     User saveUserEntity(String username, String password, Boolean male, String role, int height, int weight);
     
     boolean loginUserEntity(String username, String password);
}
