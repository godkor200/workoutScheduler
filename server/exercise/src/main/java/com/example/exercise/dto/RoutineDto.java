package com.example.exercise.dto;

import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RoutineDto {
     
     private String routineName;
     
     private LocalDateTime routineDate;
     
}
