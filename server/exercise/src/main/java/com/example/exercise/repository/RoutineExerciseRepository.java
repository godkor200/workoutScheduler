package com.example.exercise.repository;

import java.util.List;

import com.example.exercise.model.entity.RoutineExercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineExerciseRepository extends JpaRepository<RoutineExercise, Long> {
     
     List<RoutineExercise> findAllByRoutine_Id(Long id);
}
