package com.example.exercise.controller;

import com.example.exercise.dto.ExerciseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {
     
     @PostMapping("/add")
     public void addNewExercise(@Valid @RequestBody ExerciseDto exerciseDto) {
          System.out.println(exerciseDto);
     }
     
}
