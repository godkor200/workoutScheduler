package com.example.exercise.util.Jwt;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class JwtRequest implements Serializable {
     
     private static final long serialVersionUID = 5926468583005150707L;
     
     private String username;
     
     private String password;
}
