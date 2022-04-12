package com.example.exercise.dao;

import com.example.exercise.dto.RoutineDto;
import com.example.exercise.model.entity.Routine;
import com.example.exercise.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface RoutineDAO {
     
     Optional<Routine> findById(Long id);
     
     Routine saveRoutine(RoutineDto routine);
     
     void saveUserRoutine(User user, Routine routine);
     
     List<Optional<Routine>> getRoutines(String id);
     
}
