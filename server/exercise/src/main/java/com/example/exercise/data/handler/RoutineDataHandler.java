package com.example.exercise.data.handler;

import com.example.exercise.model.entity.Routine;

import java.time.LocalDateTime;

public interface RoutineDataHandler {
     
     Routine save(String routineName, LocalDateTime RoutineDate);
}
