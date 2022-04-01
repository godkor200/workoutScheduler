package com.example.exercise.service;

import com.example.exercise.dto.ExerciseDto;
import com.example.exercise.model.entity.Exercise;
import com.example.exercise.model.entity.Routine;

public interface ExerciseService {
     
     Exercise saveExercise(ExerciseDto exerciseDto);
     
     void saveRoutineExercise(Exercise exercise, Routine routine);
}
