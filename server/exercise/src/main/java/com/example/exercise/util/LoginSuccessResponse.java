package com.example.exercise.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@AllArgsConstructor
@Data
public class LoginSuccessResponse {
     
     private String token;
     
     private LocalDateTime timestamp;
     
     private HttpStatus status;
     
     private String error;
}

