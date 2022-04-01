package com.example.exercise.util.Exception;

import com.example.exercise.util.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WrongPasswordException extends RuntimeException {
     
     private final ErrorCode errorCode;
     
     public WrongPasswordException(String message, ErrorCode errorCode) {
          // 부모클래스쪽으로 전달받은 메세지를 반환
          super(message);
          this.errorCode = errorCode;
          
     }
}
