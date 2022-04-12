package com.example.exercise.dto;

import lombok.*;


import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RoutineDto {
     
     private String routineName;
     
     
     private LocalDate routineDate;
     
}
