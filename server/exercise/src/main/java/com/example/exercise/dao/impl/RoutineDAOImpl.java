package com.example.exercise.dao.impl;

import com.example.exercise.dao.RoutineDAO;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class RoutineDAOImpl implements RoutineDAO {
     
     @Autowired
     RoutineRepository routineRepository;
     
     @Autowired
     UserRoutineRepository userRoutineRepository;
     
     @Autowired
     public RoutineDAOImpl(RoutineRepository routineRepository, UserRoutineRepository userRoutineRepository) {
          this.routineRepository = routineRepository;
          this.userRoutineRepository = userRoutineRepository;
     }
     
     @Override
     public Optional<Routine> findById(Long id) {
          return routineRepository.findById(id);
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
     public void saveUserRoutine(User user, Routine routine) {
          UserRoutine newUserRoutine = new UserRoutine();
          newUserRoutine.setUser(user);
          newUserRoutine.setRoutine(routine);
          userRoutineRepository.save(newUserRoutine);
          
     }
     
     @Override
     public List<Optional<Routine>> getRoutines(String id) {
          Long Uid = Long.valueOf(id);
          List<UserRoutine> userRoutines = userRoutineRepository.findAllByUser_id(Uid);
          List<Optional<Routine>> routines = new ArrayList<>();
          userRoutines
                  .forEach(e -> {
                       routines.add(routineRepository.findById(e.getRoutine()
                                                                .getId()));
                  });
          return routines;
     }
}
