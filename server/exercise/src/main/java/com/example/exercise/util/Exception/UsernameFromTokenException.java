package com.example.exercise.util.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsernameFromTokenException extends RuntimeException {
     
     public UsernameFromTokenException(String message) {
          super(message);
     }
}
