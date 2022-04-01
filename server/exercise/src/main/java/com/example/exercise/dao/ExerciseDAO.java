package com.example.exercise.dao;

import com.example.exercise.dto.ExerciseDto;
import com.example.exercise.model.entity.Exercise;

public interface ExerciseDAO {
     
     Exercise saveExercise(ExerciseDto exerciseDto);
}
