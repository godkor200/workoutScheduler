package com.example.exercise.util.Exception;

import com.example.exercise.util.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DefaultServerException extends RuntimeException {
     
     private ErrorCode errorCode;
     
     public DefaultServerException(String message, ErrorCode errorCode) {
          super(message);
          this.errorCode = errorCode;
     }
}
