package com.example.exercise.dao.impl;

import com.example.exercise.dao.ExerciseDAO;
import com.example.exercise.dto.ExerciseDto;
import com.example.exercise.model.entity.Exercise;
import com.example.exercise.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ExerciseDAOImpl implements ExerciseDAO {
     
     @Autowired
     private ExerciseRepository exerciseRepository;
     
     @Autowired
     private void ExerciseDAO(ExerciseRepository exerciseRepository) {
          this.exerciseRepository = exerciseRepository;
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
