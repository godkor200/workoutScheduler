package com.example.exercise.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
     
     @JsonManagedReference
     @OneToMany(mappedBy = "exercise")
     private List<RoutineExercise> routineExerciseList = new ArrayList<>();
     
     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
               return false;
          Exercise exercise = (Exercise) o;
          return id != null && Objects.equals(id, exercise.id);
     }
     
     @Override
     public int hashCode() {
          return getClass().hashCode();
     }
}
