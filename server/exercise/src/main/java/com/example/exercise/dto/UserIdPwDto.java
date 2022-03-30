package com.example.exercise.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserIdPwDto {
     
     @NotBlank
     private String username;
     
     @NotBlank
     private String password;
}
