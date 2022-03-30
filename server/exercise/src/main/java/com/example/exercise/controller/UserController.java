package com.example.exercise.controller;

import com.example.exercise.util.ErrorCode;
import com.example.exercise.util.Exception.ExceptionResponse;
import com.example.exercise.util.Exception.UserDuplicateException;
import com.example.exercise.util.Exception.UserFoundExceptions;
import com.example.exercise.util.Exception.UserNotFoundException;
import com.example.exercise.util.LoginSuccessResponse;
import com.example.exercise.dto.UserIdPwDto;
import com.example.exercise.dto.UserDto;

import javax.validation.Valid;

import com.example.exercise.service.UserService;
import com.example.exercise.util.JwtTokenUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/user")
public class UserController {
     
     @Autowired
     private AuthenticationManager authenticationManager;
     
     @Autowired
     private JwtTokenUtil jwtTokenUtil;
     
     @Autowired
     private UserService userService;
     
     @Autowired
     public void userContoller(UserService userService) {
          this.userService = userService;
     }
     
     @PostMapping("/signup")
     public ResponseEntity<?> signUpUser(@Valid @RequestBody UserDto userDto) {
          String user = userDto.toString();
          if (userDto.getUsername()
                     .equals("") || userDto.getPassword()
                                           .isEmpty()) {
               return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                    .body("");
          }
          String username = userDto.getUsername();
          String password = userDto.getPassword();
          boolean male = userDto.isMale();
          String role = userDto.getRole();
          int height = userDto.getHeight();
          int weight = userDto.getWeight();
          
          if (userService.findUserDetail(username) != null) {
               throw new UserDuplicateException("username duplicated", ErrorCode.USERNAME_DUPLICATION);
          }
          UserDto response = userService.saveUser(username, password, male, role, height, weight);
          String token = jwtTokenUtil.generateToken(username);
          LocalDateTime timeNow = LocalDateTime.now();
          return ResponseEntity.ok(new LoginSuccessResponse(token, timeNow, HttpStatus.CREATED, "OK"));
     }
     
     @PostMapping("/signin")
     public ResponseEntity<LoginSuccessResponse> signInUser(@Valid @RequestBody UserIdPwDto userIdPwDAO) throws IllegalArgumentException {
          
          String id = userIdPwDAO.getUsername();
          String pw = userIdPwDAO.getPassword();
          
          Boolean result = userService.login(id, pw);
          if (!result) {
               throw new UserNotFoundException("Something Wrong Or user not found", ErrorCode.NOT_FOUND);
          }
          String token = jwtTokenUtil.generateToken(id);
          LocalDateTime timeNow = LocalDateTime.now();
          return ResponseEntity.ok(new LoginSuccessResponse(token, timeNow, HttpStatus.FOUND, "OK"));
     }
}
