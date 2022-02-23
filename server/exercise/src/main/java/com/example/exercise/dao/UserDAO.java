package com.example.exercise.dao;

import com.example.exercise.model.entity.User;

public interface UserDAO {
     
     User saveUser(User user);
     
     Boolean matchPw(String username, String password);
}
