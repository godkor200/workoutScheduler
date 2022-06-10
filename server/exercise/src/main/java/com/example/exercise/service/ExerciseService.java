package com.example.exercise.service;

import com.example.exercise.dto.ExerciseDto;
import com.example.exercise.model.entity.Exercise;
import com.example.exercise.model.entity.Routine;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {
     
     Exercise saveExercise(ExerciseDto exerciseDto);
     
     List<Optional<Exercise>> getExercise(String id);
     
     void saveRoutineExercise(Exercise exercise, Routine routine);
}
