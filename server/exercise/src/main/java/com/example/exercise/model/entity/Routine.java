package com.example.exercise.model.entity;

import java.util.List;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Routine {
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     
     private String routineName;
     
     private LocalDateTime exerciseTime;
     
     private LocalDateTime createdAt;
     
     private String createdBy;
     
     private LocalDateTime updateAt;
     
     private String updateBy;
     
     @OneToMany(mappedBy = "routine")
     private List<UserRoutine> userRoutine;
}
