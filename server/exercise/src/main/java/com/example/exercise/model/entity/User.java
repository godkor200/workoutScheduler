package com.example.exercise.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduser;
    private String account;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updateAt;
    private String updateBy;
}
