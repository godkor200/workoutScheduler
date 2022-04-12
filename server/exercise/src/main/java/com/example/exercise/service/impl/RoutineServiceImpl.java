package com.example.exercise.service.impl;

import com.example.exercise.dao.RoutineDAO;
import com.example.exercise.dto.RoutineDto;
import com.example.exercise.repository.RoutineRepository;
import com.example.exercise.service.RoutineService;
import com.example.exercise.model.entity.Routine;
import com.example.exercise.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoutineServiceImpl implements RoutineService {
     
     RoutineDAO routineDAO;
     
     RoutineRepository routineRepository;
     
     @Autowired
     public void routineServiceImpl(RoutineDAO routineDAO) {
          this.routineDAO = routineDAO;
     }
     
     @Override
     public Optional<Routine> findById(Long id) {
          return routineDAO.findById(id);
     }
     
     @Override
     public Routine saveRoutine(RoutineDto routineDto) {
          return routineDAO.saveRoutine(routineDto);
     }
     
     @Override
     public void saveUserRoutine(User user, Routine routine) {
          routineDAO.saveUserRoutine(user, routine);
     }
     
     @Override
     public List<Optional<Routine>> getRoutine(String id) {
          return routineDAO.getRoutines(id);
     }
}
