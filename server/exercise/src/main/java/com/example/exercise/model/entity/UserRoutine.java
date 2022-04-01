package com.example.exercise.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "user_routine")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UserRoutineId.class)
public class UserRoutine {
     
     @Id
     @ManyToOne
     @JoinColumn(name = "routine_id")
     private Routine routine;
     
     @Id
     @ManyToOne
     @JoinColumn(name = "user_id")
     private User user;
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     
     
}
