package com.example.exercise.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
public class UserRoutineId implements Serializable {
     
     private Long user;
     
     private Long routine;
}
