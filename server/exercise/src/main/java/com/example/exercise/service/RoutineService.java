package com.example.exercise.service;

import com.example.exercise.dto.RoutineDto;
import com.example.exercise.model.entity.Routine;
import com.example.exercise.model.entity.User;

public interface RoutineService {
     
     Routine saveRoutine(RoutineDto routineDto);
     
     void saveUserRoutine(User user, Routine routine);
}
