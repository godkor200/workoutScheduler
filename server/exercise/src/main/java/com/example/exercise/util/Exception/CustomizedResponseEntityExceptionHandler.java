package com.example.exercise.util.Exception;

import com.example.exercise.util.ErrorCode;
import com.example.exercise.util.Response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
     
     //BAD REQUEST
     @ExceptionHandler(BadReqException.class)
     public final ResponseEntity<Object> handleBadReqException(BadReqException ex, WebRequest request) {
          ErrorResponse response = new ErrorResponse(ErrorCode.BAD_REQUEST);
          return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
     }
     
     //Default exception
     @ExceptionHandler(DefaultServerException.class)
     public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
          ErrorResponse response = new ErrorResponse(ErrorCode.INTER_SERVER_ERROR);
          return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
     }
     
     //비밀번호가 틀릴떄
     @ExceptionHandler(WrongPasswordException.class)
     public final ResponseEntity<Object> handleUnauthorizedExceptions(WrongPasswordException ex, WebRequest request) {
          ErrorResponse response = new ErrorResponse(ErrorCode.WRONG_PASSWORD);
          return new ResponseEntity<>(response, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
     }
     
     
     //로그인시 유저를 못찾을 때
     @ExceptionHandler(UserNotFoundException.class)
     public final ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException ex, WebRequest request) {
          ErrorResponse response = new ErrorResponse(ErrorCode.NOT_FOUND);
          return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
     }
     
     //유저가 중복 되어 있을때
     @ExceptionHandler(UserDuplicateException.class)
     public final ResponseEntity<Object> handleUserFoundExceptions(UserDuplicateException ex, WebRequest request) {
          ErrorResponse response = new ErrorResponse(ErrorCode.USERNAME_DUPLICATION);
          return new ResponseEntity<>(response, HttpStatus.CONFLICT);
     }
}