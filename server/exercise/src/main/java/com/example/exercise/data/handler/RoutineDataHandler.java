package com.example.exercise.data.handler;

import com.example.exercise.model.entity.Routine;

import java.time.LocalDate;

public interface RoutineDataHandler {
     
     Routine save(String routineName, LocalDate routineDate);
}
