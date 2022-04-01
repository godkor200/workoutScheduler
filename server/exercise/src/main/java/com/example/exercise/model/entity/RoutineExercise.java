package com.example.exercise.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "routine_exercise")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(RoutineExerciseId.class)
public class RoutineExercise {
     
     @Id
     @ManyToOne
     @JoinColumn(name = "routine_id")
     Routine routine;
     
     @Id
     @ManyToOne
     @JoinColumn(name = "exercise_id")
     Exercise exercise;
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     
     
}
