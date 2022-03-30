package com.example.exercise.util.Exception;

import com.example.exercise.util.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundException extends RuntimeException {
     
     private ErrorCode errorCode;
     
     public UserNotFoundException(String message, ErrorCode errorCode) {
          // 부모클래스쪽으로 전달받은 메세지를 반환
          super(message);
          this.errorCode = errorCode;
          
     }
}
