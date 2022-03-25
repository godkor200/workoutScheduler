package com.example.exercise.util;

import com.example.exercise.util.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
     
     private int status;
     
     private String message;
     
     private String code;
     
     public ErrorResponse(ErrorCode errorCode) {
          this.status = errorCode.getStatus();
          this.message = errorCode.getMessage();
          this.code = errorCode.getErrorCode();
     }
}