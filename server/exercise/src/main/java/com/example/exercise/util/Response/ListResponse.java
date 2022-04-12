package com.example.exercise.util.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ListResponse {
     
     private LocalDateTime timestamp;
     
     private HttpStatus status;
     
     private String error;
     
     private List<?> list;
}
