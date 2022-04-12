package com.example.exercise.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_routine")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@IdClass(UserRoutineId.class)
public class UserRoutine {
     
     @Id
     @ManyToOne
     @JsonBackReference
     @JoinColumn(name = "user_id", referencedColumnName = "user_id")
     private User user;
     
     @Id
     @ManyToOne
     @JsonBackReference
     @JoinColumn(name = "routine_id", referencedColumnName = "routine_id")
     private Routine routine;
     
     
}
