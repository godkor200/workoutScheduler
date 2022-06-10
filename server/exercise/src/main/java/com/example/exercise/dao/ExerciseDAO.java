package com.example.exercise.dao;

import com.example.exercise.dto.ExerciseDto;
import com.example.exercise.model.entity.Exercise;
import com.example.exercise.model.entity.Routine;

import java.util.List;
import java.util.Optional;

public interface ExerciseDAO {
     
     List<Optional<Exercise>> getExercise(String id);
     
     Exercise saveExercise(ExerciseDto exerciseDto);
     
     
}
