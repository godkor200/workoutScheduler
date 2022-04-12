package com.example.exercise.dto;

import com.example.exercise.model.entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto {
     
     @NotBlank
     @NotNull
     private String username;
     
     @NotBlank
     @NotNull
     private String password;
     
     @NotNull
     private boolean male;
     
     private String role;
     
     @NotNull
     private Integer height;
     
     
     @NotNull
     private Integer weight;
     
     
     public User toEntity() {
          return User.builder()
                     .username(username)
                     .password(password)
                     .male(male)
                     .height(height)
                     .weight(weight)
                     .role(role)
                     .build();
     }
}
