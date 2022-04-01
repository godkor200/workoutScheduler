package com.example.exercise.repository;

import com.example.exercise.model.entity.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {


}
