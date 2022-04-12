package com.example.exercise.model.entity;

import com.example.exercise.dto.UserDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.hibernate.Hibernate;


@Entity
@Getter
@Setter
//@ToString
@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class User {
     
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "user_id")
     private Long id;
     
     private String username;
     
     private String password;
     
     private String role;
     
     private boolean male;
     
     private int height;
     
     private int weight;
     
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
     private LocalDateTime createdAt;
     
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
     private LocalDateTime updateAt;
     
     private String updateBy;
     
     //1:N
     @JsonManagedReference
     @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
     private List<UserRoutine> userRoutine = new ArrayList<>();
     
     public User(String username, String password, Boolean male, int height, int weight, String role, LocalDateTime currentTime) {
          this.username = username;
          this.password = password;
          this.male = male;
          this.role = role;
          this.height = height;
          this.weight = weight;
          this.createdAt = currentTime;
     }


//     public User(String username, String password, Boolean male, int height, int weight, String role, LocalDateTime currentTime) {
//     }
     
     
     public UserDto toDto() {
          return UserDto.builder()
                        .username(username)
                        .password(password)
                        .male(male)
                        .height(height)
                        .weight(weight)
                        .build();
     }
     
     @Override
     public boolean equals(Object o) {
          if (this == o) {
               return true;
          }
          if (o == null || Hibernate.getClass(this) != Hibernate.getClass(
                  o)) {
               return false;
          }
          User user = (User) o;
          return id != null && Objects.equals(id, user.id);
     }
     
     @Override
     public int hashCode() {
          return getClass().hashCode();
     }
     
}
