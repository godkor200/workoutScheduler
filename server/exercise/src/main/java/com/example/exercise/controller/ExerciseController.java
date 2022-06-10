package com.example.exercise.controller;

import com.example.exercise.dto.ExerciseDto;
import com.example.exercise.model.entity.Exercise;
import com.example.exercise.model.entity.Routine;
import com.example.exercise.service.ExerciseService;
import com.example.exercise.service.RoutineService;
import com.example.exercise.util.ErrorCode;
import com.example.exercise.util.Exception.BadReqException;
import com.example.exercise.util.Exception.NotFoundException;
import com.example.exercise.util.Response.CreateResponse;
import com.example.exercise.util.Response.ListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {
     
     @Autowired
     private ExerciseService exerciseService;
     
     @Autowired
     private RoutineService routineService;
     
     @Autowired
     public void exerciseController(ExerciseService exerciseService, RoutineService routineService) {
          this.exerciseService = exerciseService;
          this.routineService = routineService;
     }
     
     @GetMapping()
     public ResponseEntity<ListResponse> getExercise(@RequestParam Long id) {
          if (String.valueOf(id)
                    .isEmpty()) {
               throw new BadReqException("not exists ID", ErrorCode.NOT_FOUND);
          }
          List<Optional<Exercise>> getExercise = exerciseService.getExercise(String.valueOf(id));
          if (getExercise.isEmpty()) {
               throw new NotFoundException("not found", ErrorCode.NOT_FOUND);
          }
          return ResponseEntity.ok(new ListResponse(LocalDateTime.now(), HttpStatus.FOUND, "NO", getExercise));
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
