package com.example.exercise.controller;

import com.example.exercise.model.entity.User;
import com.example.exercise.util.ErrorCode;
import com.example.exercise.util.Exception.UserDuplicateException;
import com.example.exercise.util.Exception.UserNotFoundException;
import com.example.exercise.util.Exception.WrongPasswordException;
import com.example.exercise.util.Exception.BadReqException;
import com.example.exercise.util.Response.LoginSuccessResponse;
import com.example.exercise.dto.UserIdPwDto;
import com.example.exercise.dto.UserDto;

import javax.validation.Valid;

import com.example.exercise.service.UserService;
import com.example.exercise.util.Jwt.JwtTokenUtil;
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
     public ResponseEntity<LoginSuccessResponse> signUpUser(@Valid @RequestBody UserDto userDto) {
          String username = userDto.getUsername();
          String password = userDto.getPassword();
          if (username
                  .equals("") || password
                  .isEmpty()) {
               throw new BadReqException("username or password is empty", ErrorCode.BAD_REQUEST);
          }
          if (userService.findUserDetail(username) != null) {
               throw new UserDuplicateException("username duplicated", ErrorCode.USERNAME_DUPLICATION);
          }
          User newUser = userService.saveUser(userDto);
          String token = jwtTokenUtil.generateToken(username);
          LocalDateTime timeNow = LocalDateTime.now();
          return ResponseEntity.ok(new LoginSuccessResponse(token, timeNow, HttpStatus.CREATED, "NO"));
     }
     
     @PostMapping("/signin")
     public ResponseEntity<LoginSuccessResponse> signInUser(@Valid @RequestBody UserIdPwDto userIdPwDAO) {
          Boolean result = userService.login(userIdPwDAO);
          if (result == null)
               throw new UserNotFoundException("invalid ID", ErrorCode.NOT_FOUND);
          if (!result)
               throw new WrongPasswordException("invalid Password", ErrorCode.WRONG_PASSWORD);
          String token = jwtTokenUtil.generateToken(userIdPwDAO.getUsername());
          LocalDateTime timeNow = LocalDateTime.now();
          return ResponseEntity.ok(new LoginSuccessResponse(token, timeNow, HttpStatus.FOUND, "NO"));
     }
}
