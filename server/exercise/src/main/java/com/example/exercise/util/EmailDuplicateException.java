package com.example.exercise.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDuplicateException extends RuntimeException {
     
     private ErrorCode errorCode;
     
     public EmailDuplicateException(String message, ErrorCode errorCode) {
          super(message);
          this.errorCode = errorCode;
     }
}
