package com.example.exercise.util.Exception;

import com.example.exercise.util.ErrorCode;
import com.example.exercise.util.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
     
     //Default exception
     @ExceptionHandler(Exception.class)
     public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
          ExceptionResponse exceptionResponse = new ExceptionResponse().builder()
                                                                       .timestamp(new Date())
                                                                       .message(ex.getMessage())
                                                                       .details(request.getDescription(false))
                                                                       .build();
          return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
     }
     
     @ExceptionHandler(UserNotFoundException.class)
     public final ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException ex, WebRequest request) {
          
          ErrorResponse response = new ErrorResponse(ErrorCode.NOT_FOUND);
          return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
     }
     
     @ExceptionHandler(UserDuplicateException.class)
     public final ResponseEntity<Object> handleUserFoundExceptions(UserDuplicateException ex, WebRequest request) {
          
          ErrorResponse response = new ErrorResponse(ErrorCode.USERNAME_DUPLICATION);
          return new ResponseEntity<>(response, HttpStatus.CONFLICT);
     }
}