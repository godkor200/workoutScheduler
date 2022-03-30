package com.example.exercise.data.handler.impl;

import com.example.exercise.data.handler.RoutineDataHandler;
import com.example.exercise.model.entity.Routine;
import com.example.exercise.repository.RoutineRepository;

import java.time.LocalDateTime;
import java.time.LocalDate;

public class RoutineDateHandlerImpl implements RoutineDataHandler {
     
     private RoutineRepository routineRepository;
     
     @Override
     public Routine save(String routineName, LocalDate routineDate) {
          LocalDateTime timeNow = LocalDateTime.now();
          Routine newRoutine = new Routine(routineName, routineDate, timeNow);
          return routineRepository.save(newRoutine);
     }
}
