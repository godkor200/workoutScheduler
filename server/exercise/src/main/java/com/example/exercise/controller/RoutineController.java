package com.example.exercise.controller;

import com.example.exercise.dto.RoutineDto;
import com.example.exercise.service.RoutineService;
import com.example.exercise.service.UserService;
import com.example.exercise.util.ErrorCode;
import com.example.exercise.util.Exception.DefaultServerException;
import com.example.exercise.util.Exception.NotFoundException;
import com.example.exercise.util.Jwt.JwtTokenUtil;
import com.example.exercise.util.Response.CreateResponse;
import com.example.exercise.util.Response.ListResponse;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import com.example.exercise.model.entity.Routine;
import com.example.exercise.model.entity.User;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


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
     public ResponseEntity<CreateResponse> addNewRoutine(HttpServletRequest request, @Valid @RequestBody RoutineDto routineDto) {
          final String reqTokenHeader = request.getHeader("Authorization");
          Routine routine = routineService.saveRoutine(routineDto);
          if (!routine.getRoutineName()
                      .equals(routineDto.getRoutineName())) {
               throw new DefaultServerException("Something Wrong", ErrorCode.INTER_SERVER_ERROR);
          } else {
               Claims userName = jwtTokenUtil.getAllClaimFromToken(reqTokenHeader.substring(7));
               User user = userService.findUserDetail(userName.getSubject());
               routineService.saveUserRoutine(user, routine);
          }
          return ResponseEntity.ok(new CreateResponse(LocalDateTime.now(), HttpStatus.CREATED, "NO"));
     }
     
     @GetMapping("/")
     public ResponseEntity<ListResponse> getRoutine(HttpServletRequest request) {
          final String reqTokenHeader = request.getHeader("Authorization");
          Claims user = jwtTokenUtil.getAllClaimFromToken(reqTokenHeader.substring(7));
          List<Optional<Routine>> getRoutines = routineService.getRoutine(user.getId());
          if (getRoutines.isEmpty()) {
               throw new NotFoundException("Not Found", ErrorCode.NOT_FOUND);
          }
          return ResponseEntity.ok(new ListResponse(LocalDateTime.now(), HttpStatus.OK, "NO", getRoutines));
     }
}
