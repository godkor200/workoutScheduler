package com.example.exercise.util.Exception;

public class UserFoundExceptions extends RuntimeException {
     
     public UserFoundExceptions(String message) {
          // 부모클래스쪽으로 전달받은 메세지를 반환
          super(message);
     }
     
}
