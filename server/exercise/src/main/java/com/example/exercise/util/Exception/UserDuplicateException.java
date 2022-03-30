package com.example.exercise.util.Exception;

import com.example.exercise.util.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDuplicateException extends RuntimeException {
     
     private ErrorCode errorCode;
     
     public UserDuplicateException(String message, ErrorCode errorCode) {
          super(message);
          this.errorCode = errorCode;
     }
}
