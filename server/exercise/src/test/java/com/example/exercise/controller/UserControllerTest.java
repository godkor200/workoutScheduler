package com.example.exercise.controller;


import com.example.exercise.model.entity.User;
import com.example.exercise.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
class UserControllerTest {
     
     @Autowired
     UserRepository userRepository;
     
     @Autowired
     public UserControllerTest(UserRepository userRepository) {
          this.userRepository = userRepository;
     }
     
     @Test
     void 회원가입_데이터_추가() {
          IntStream.range(1, 10)
                   .forEach(i -> {
                        boolean man = i % 2 == 0;
                        User user = new User("user" + i, "password" + i, man, 170 + i, 70 + i, "admin", LocalDateTime.now());
                        userRepository.save(user);
                   });
          List<User> users = userRepository.findAll();
     }

//     @Test
//     void 회원로그인() {
//     }
//}
}