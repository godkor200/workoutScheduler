package com.example.exercise.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class Routine {
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     
     private String routineName;
     
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
     private LocalDate exerciseTime;
     
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
     private LocalDateTime createdAt;
     
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
     private LocalDateTime updateAt;
     
     @OneToMany(mappedBy = "routine")
     private List<UserRoutine> userRoutine = new ArrayList<>();
     
     public Routine(String routineName, LocalDate routineDate, LocalDateTime timeNow) {
          this.routineName = routineName;
          this.exerciseTime = routineDate;
          this.createdAt = timeNow;
     }
     
     
     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
               return false;
          Routine routine = (Routine) o;
          return id != null && Objects.equals(id, routine.id);
     }
     
     @Override
     public int hashCode() {
          return getClass().hashCode();
     }
}
