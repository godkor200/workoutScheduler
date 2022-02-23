package com.example.exercise.dto;

import com.example.exercise.model.entity.User;

import java.time.LocalDateTime;
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
     
     @NotNull
     private String username;
     
     @NotNull
     private String password;
     
     @NotNull
     private boolean male;
     
     private String role;
     
     @NotNull
     private Integer height;
     
     
     @NotNull
     private Integer weight;
     
     @CreatedDate
     private LocalDateTime createdAt;
     
     @UpdateTimestamp
     private LocalDateTime updateAt;
     
     public User toEntity() {
          return User.builder()
                     .username(username)
                     .password(password)
                     .male(male)
                     .height(height)
                     .weight(weight)
                     .role(role)
                     .createdAt(createdAt)
                     .updateAt(updateAt)
                     .build();
     }
}
