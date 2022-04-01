package com.example.exercise.controller;

import com.example.exercise.dto.ExerciseDto;
import com.example.exercise.model.entity.Exercise;
import com.example.exercise.model.entity.Routine;
import com.example.exercise.service.ExerciseService;
import com.example.exercise.service.RoutineService;
import com.example.exercise.util.Response.CreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {
     
     
     private ExerciseService exerciseService;
     
     
     private RoutineService routineService;
     
     @Autowired
     public void exerciseController(ExerciseService exerciseService, RoutineService routineService) {
          this.exerciseService = exerciseService;
          this.routineService = routineService;
     }
     
     @PostMapping("/add")
     public ResponseEntity<CreateResponse> addNewExercise(@Valid @RequestBody ExerciseDto exerciseDto) {
          Optional<Routine> routine = routineService.findById(exerciseDto.getRoutineId());
          Exercise exercise = exerciseService.saveExercise(exerciseDto);
          Routine routineOfExercise = routine.orElse(null);
          exerciseService.saveRoutineExercise(exercise, routineOfExercise);
          return ResponseEntity.ok(new CreateResponse(LocalDateTime.now(), HttpStatus.CREATED, "NO"));
     }
     
}
