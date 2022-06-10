package com.example.exercise.dao.impl;

import com.example.exercise.dao.ExerciseDAO;
import com.example.exercise.dto.ExerciseDto;
import com.example.exercise.model.entity.Exercise;
import com.example.exercise.model.entity.RoutineExercise;
import com.example.exercise.repository.RoutineExerciseRepository;

import com.example.exercise.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExerciseDAOImpl implements ExerciseDAO {
     
     @Autowired
     private ExerciseRepository exerciseRepository;
     
     @Autowired
     private RoutineExerciseRepository routineExerciseRepository;
     
     @Autowired
     private void ExerciseDAO(ExerciseRepository exerciseRepository, RoutineExerciseRepository routineExerciseRepository) {
          this.exerciseRepository = exerciseRepository;
          this.routineExerciseRepository = routineExerciseRepository;
     }
     
     @Override
     public List<Optional<Exercise>> getExercise(String id) {
          Long Uid = Long.valueOf(id);
          List<RoutineExercise> routineExercises = routineExerciseRepository.findAllByRoutine_Id(Uid);
          List<Optional<Exercise>> exercise = new ArrayList<>();
          routineExercises.forEach(e -> {
               exercise.add(exerciseRepository.findById(e.getExercise()
                                                         .getId()));
          });
          return exercise;
     }
     
     @Override
     public Exercise saveExercise(ExerciseDto exerciseDto) {
          Exercise newExercise = new Exercise();
          newExercise.setExerciseName(exerciseDto.getExerciseName());
          newExercise.setExerciseSet(exerciseDto.getExerciseSet());
          newExercise.setExerciseWeight(exerciseDto.getExerciseWeight());
          newExercise.setExerciseCategory(exerciseDto.getExerciseCategory());
          newExercise.setExerciseDesc(exerciseDto.getExerciseDesc());
          newExercise.setCreatedAt(LocalDateTime.now());
          return exerciseRepository.save(newExercise);
     }
}
