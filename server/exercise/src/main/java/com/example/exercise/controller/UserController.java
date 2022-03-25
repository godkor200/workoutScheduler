package com.example.exercise.controller;

import com.example.exercise.dto.UserIdPwDAO;
import com.example.exercise.dto.UserDto;

import javax.validation.Valid;

import com.example.exercise.service.UserService;
import com.example.exercise.util.JwtTokenUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     public ResponseEntity<String> signUpUser(@Valid @RequestBody UserDto userDto) {
          String user = userDto.toString();
          System.out.println("println ! " + user);
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
          UserDto response = userService.saveUser(username, password, male, role, height, weight);
          String token = jwtTokenUtil.generateToken(username);
          return ResponseEntity.ok(token);
     }
     
     @PostMapping("/signin")
     public ResponseEntity<?> signInUser(@Valid @RequestBody UserIdPwDAO userIdPwDAO) throws IllegalArgumentException {
          
          String id = userIdPwDAO.getUsername();
          String pw = userIdPwDAO.getPassword();
          
          Boolean result = userService.login(id, pw);
          if (!result) {
               throw new IllegalArgumentException("Something Wrong Or user not found");
          }
          String token = jwtTokenUtil.generateToken(id);
          return ResponseEntity.ok(token);
     }
     
}
