package com.example.exercise.dao;

import com.example.exercise.dto.RoutineDto;
import com.example.exercise.model.entity.Routine;
import com.example.exercise.model.entity.User;
import com.example.exercise.model.entity.UserRoutine;

public interface RoutineDAO {
     
     Routine saveRoutine(RoutineDto routine);
     
     UserRoutine saveUserRoutine(User user, Routine routine);
     
}
