package com.example.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseDto {
     
     private Long routineId;
     
     private String exerciseName;
     
     private String exerciseCategory;
     
     private String exerciseDesc;
     
     private int exerciseSet;
     
     private int exerciseWeight;
}
