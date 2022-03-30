package com.example.exercise.dao.impl;

import com.example.exercise.dao.RoutineDAO;
import com.example.exercise.data.handler.RoutineDataHandler;
import com.example.exercise.dto.RoutineDto;
import com.example.exercise.model.entity.Routine;
import com.example.exercise.model.entity.User;
import com.example.exercise.model.entity.UserRoutine;
import com.example.exercise.repository.RoutineRepository;
import com.example.exercise.repository.UserRoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;

@Service
public class RoutineDAOImpl implements RoutineDAO {
     
     RoutineDataHandler routineDataHandler;
     
     RoutineRepository routineRepository;
     
     UserRoutineRepository userRoutineRepository;
     
     @Autowired
     public RoutineDAOImpl(RoutineRepository routineRepository, UserRoutineRepository userRoutineRepository) {
          this.routineRepository = routineRepository;
          this.userRoutineRepository = userRoutineRepository;
     }
     
     @Override
     public Routine saveRoutine(RoutineDto routine) {
          
          
          String routineName = routine.getRoutineName();
          
          LocalDate exerciseTime = routine.getRoutineDate();
          
          LocalDateTime createdAt = LocalDateTime.now();
          
          Routine newRoutine = new Routine(routineName, exerciseTime, createdAt);
          
          return routineRepository.save(newRoutine);
     }
     
     @Override
     public UserRoutine saveUserRoutine(User user, Routine routine) {
//          final List<UserRoutine> list = userRoutineRepository.findAllById(userId);
          final UserRoutine newUserRoutine = new UserRoutine();
          newUserRoutine.setUser(user);
          newUserRoutine.setRoutine(routine);
          
          
          return userRoutineRepository.save(newUserRoutine);
//          return (UserRoutine) list;
     }
}
