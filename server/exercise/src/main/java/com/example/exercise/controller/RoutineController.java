package com.example.exercise.controller;

import com.example.exercise.dto.RoutineDto;
import com.example.exercise.service.RoutineService;
import com.example.exercise.service.UserService;
import com.example.exercise.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.exercise.model.entity.Routine;
import com.example.exercise.model.entity.User;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/routine")
public class RoutineController {
     
     @Autowired
     private AuthenticationManager authenticationManager;
     
     @Autowired
     private RoutineService routineService;
     
     @Autowired
     private JwtTokenUtil jwtTokenUtil;
     
     @Autowired
     private UserService userService;
     
     @Autowired
     public void routineController(RoutineService routineService, UserService userService) {
          this.routineService = routineService;
          this.userService = userService;
     }
     
     
     @PostMapping("/add")
     public ResponseEntity<String> addNewExercise(HttpServletRequest request, @Valid @RequestBody RoutineDto routineDto) throws IllegalArgumentException {
          final String reqTokenHeader = request.getHeader("Authorization");
          Routine routine = routineService.saveRoutine(routineDto);
          if (!routine.getRoutineName()
                      .equals(routineDto.getRoutineName())) {
               throw new IllegalArgumentException("Something Wrong");
          } else {
               Claims userName = jwtTokenUtil.getAllClaimFromToken(reqTokenHeader.substring(7));
               User user = userService.findUserDetail(userName.getSubject());
               routineService.saveUserRoutine(user, routine);
          }
          return ResponseEntity.ok("하이");
     }
     
}
