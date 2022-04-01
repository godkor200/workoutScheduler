package com.example.exercise.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
public class RoutineExerciseId implements Serializable {
     
     private Long routine;
     
     private Long exercise;
}
