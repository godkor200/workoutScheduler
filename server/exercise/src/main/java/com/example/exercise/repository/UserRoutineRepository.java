package com.example.exercise.repository;

import com.example.exercise.model.entity.UserRoutine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoutineRepository extends JpaRepository<UserRoutine, Long> {
     
     List<UserRoutine> findAllById(Long id);
}
