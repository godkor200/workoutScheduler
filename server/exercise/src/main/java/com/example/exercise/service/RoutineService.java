package com.example.exercise.service;

import com.example.exercise.dto.RoutineDto;
import com.example.exercise.model.entity.Routine;
import com.example.exercise.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface RoutineService {
     
     Optional<Routine> findById(Long id);
     
     Routine saveRoutine(RoutineDto routineDto);
     
     void saveUserRoutine(User user, Routine routine);
     
     List<Optional<Routine>> getRoutine(String id);
}
