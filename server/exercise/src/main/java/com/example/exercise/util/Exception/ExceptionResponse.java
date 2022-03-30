package com.example.exercise.util.Exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionResponse {
     
     private Date timestamp;
     
     private String message;
     
     private String details;
     
     
}
