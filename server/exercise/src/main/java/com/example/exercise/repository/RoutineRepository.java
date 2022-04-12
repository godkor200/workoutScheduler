package com.example.exercise.repository;

import com.example.exercise.model.entity.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {

//     List<Routine> findAllByUser_id(Long id);
}
