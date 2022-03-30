package com.example.exercise.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
     NOT_FOUND(404, "COMMON-ERR-404", "NOT FOUND"),
     INTER_SERVER_ERROR(500, "COMMON-ERR-500", "INTER SERVER ERROR"),
     USERNAME_DUPLICATION(409, "MEMBER-ERR-400", "USER DUPLICATED"),
     ;
     
     private int status;
     
     private String errorCode;
     
     private String message;
}
