package com.example.exercise.repository;

import com.example.exercise.ExerciseApplicationTests;
import com.example.exercise.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends ExerciseApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();
        user.setAccount("godkor200");
        user.setEmail("godkor200@gmail.com");
        user.setPhoneNumber("010-5555-2222");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("godkor200");
        User newUser = userRepository.save(user);
        System.out.println(newUser);
    }

    @Test
    public void read(){
     Optional<User> user = userRepository.findById(2L);
     user.ifPresent(s->{
         System.out.println(s);
         System.out.println(s.getEmail());
     });

    }
    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);
        Assertions.assertTrue(user.isPresent());
        user.ifPresent(s->{
            s.setAccount("dmr");
            s.setUpdateAt(LocalDateTime.now());
            s.setUpdateBy("update method()");
            userRepository.save((s));
        });
    }

    @Test
    public void delete(){
        Optional<User> user = userRepository.findById(2L);
        Assertions.assertTrue(user.isPresent());
        user.ifPresent(s-> {
            userRepository.delete(s);
        });
        Optional<User> deleteUser = userRepository.findById(2L);
        Assertions.assertFalse(deleteUser.isPresent());
    }
}
