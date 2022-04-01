package com.example.exercise.dao;

import com.example.exercise.model.entity.User;

public interface UserDAO {
     
     User saveUser(String username, String password, Boolean male, String role, int height,
                   int weight);
     
     Boolean matchPw(String username, String password);
}
