package com.example.exercise.repository;

import com.example.exercise.model.entity.Routine;

import com.example.exercise.model.entity.UserRoutine;
import com.example.exercise.model.entity.UserRoutineId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoutineRepository extends JpaRepository<UserRoutine, UserRoutineId> {
     
     List<UserRoutine> findAllByUser_id(Long id);

//     List<UserRoutine> findAllById(Long id);

//     List<routine> findAllByUser_id(Long id);
}
