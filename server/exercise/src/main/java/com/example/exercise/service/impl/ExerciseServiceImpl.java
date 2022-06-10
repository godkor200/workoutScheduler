package com.example.exercise.service.impl;

import com.example.exercise.dao.ExerciseDAO;
import com.example.exercise.dto.ExerciseDto;
import com.example.exercise.model.entity.Exercise;
import com.example.exercise.model.entity.Routine;
import com.example.exercise.model.entity.RoutineExercise;
import com.example.exercise.repository.RoutineExerciseRepository;
import com.example.exercise.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService {
     
     @Autowired
     ExerciseDAO exerciseDAO;
     
     @Autowired
     RoutineExerciseRepository routineExerciseRepository;
     
     @Autowired
     private void exerciseService(ExerciseDAO exerciseDAO, RoutineExerciseRepository routineExerciseRepository) {
          this.exerciseDAO = exerciseDAO;
          this.routineExerciseRepository = routineExerciseRepository;
     }
     
     @Override
     public Exercise saveExercise(ExerciseDto exerciseDto) {
          return exerciseDAO.saveExercise(exerciseDto);
     }
     
     @Override
     public List<Optional<Exercise>> getExercise(String id) {
          return exerciseDAO.getExercise(id);
     }
     
     @Override
     public void saveRoutineExercise(Exercise exercise, Routine routine) {
          RoutineExercise newRoutineExercise = new RoutineExercise();
          newRoutineExercise.setExercise(exercise);
          newRoutineExercise.setRoutine(routine);
          routineExerciseRepository.save(newRoutineExercise);
     }
}
