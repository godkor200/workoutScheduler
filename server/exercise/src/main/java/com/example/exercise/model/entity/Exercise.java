package com.example.exercise.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Exercise {
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     
     private String exerciseName;
     
     private int exerciseSet;
     
     private int exerciseWeight;
     
     private String exerciseCategory;
     
     private String exerciseDesc;
     
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
     private LocalDateTime createdAt;
     
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
     private LocalDateTime updateAt;
     
     @OneToMany(mappedBy = "exercise")
     private List<RoutineExercise> routineExerciseList;
}
