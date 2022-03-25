package com.example.exercise.controller;

import com.example.exercise.dto.RoutineDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/routine")
public class RoutineController {
     
     @PostMapping("/add")
     public ResponseEntity<String> addNewExercise(@Valid @RequestBody RoutineDto routineDto) {
          System.out.println(routineDto);
          
          return ResponseEntity.ok("하이");
     }
     
}
