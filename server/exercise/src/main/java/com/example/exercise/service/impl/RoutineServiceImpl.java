package com.example.exercise.service.impl;

import com.example.exercise.dto.RoutineDto;
import com.example.exercise.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class RoutineServiceImpl implements RoutineService {
     
     RoutineDAO routineDAO;
     
     @Autowired
     public void RoutineDataHandlerImpl(RoutineDAO routineDAO) {
          this.routineDAO = routineDAO;
     }
     
     @Override
     public RoutineDto saveRoutine(RoutineDto routineDto) {
          String routineName = routineDto.getRoutineName();
          LocalDateTime routineDate = routineDto.getRoutineDate();
          return null;
     }
}
