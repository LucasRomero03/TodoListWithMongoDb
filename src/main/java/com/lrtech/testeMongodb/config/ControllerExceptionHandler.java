package com.lrtech.testeMongodb.config;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lrtech.testeMongodb.dto.exceptionDTO.CustomError;
import com.lrtech.testeMongodb.dto.exceptionDTO.ValidationError;
import com.lrtech.testeMongodb.service.exceptions.DataBaseException;
import com.lrtech.testeMongodb.service.exceptions.ForbidenException;
import com.lrtech.testeMongodb.service.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException message, HttpServletRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    CustomError error = new CustomError(Instant.now(), status.value(), message.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(error);
  }

  @ExceptionHandler(DataBaseException.class)
  public ResponseEntity<CustomError> dataBase(DataBaseException message, HttpServletRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    CustomError error = new CustomError(Instant.now(), status.value(), message.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(error);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<CustomError> methodArgumentNotValid(MethodArgumentNotValidException message,
      HttpServletRequest request) {
    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
    ValidationError error = new ValidationError(Instant.now(), status.value(), "Dados Inválidos ",
        request.getRequestURI());

    for (FieldError fieldError : message.getBindingResult().getFieldErrors()) {
      error.addError(fieldError.getField(), fieldError.getDefaultMessage());
    }
    return ResponseEntity.status(status).body(error);
  }

  @ExceptionHandler(ForbidenException.class)
  public ResponseEntity<CustomError> forbidenException(ForbidenException message, HttpServletRequest request) {
    HttpStatus status = HttpStatus.FORBIDDEN;
    CustomError error = new CustomError(Instant.now(), status.value(), message.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(error);
  }


}
