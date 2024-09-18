package com.leonardorossi.prova2024.exceptions;

import com.leonardorossi.prova2024.exceptions.customexceptions.CustomBadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>>
  handleValidationExceptions(MethodArgumentNotValidException ex) {
    
    Map<String, String> errors = new HashMap<>();
    
    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
      errors.put(error.getField(), error.getDefaultMessage());
    }
    
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }
  
  @ExceptionHandler(CustomBadRequestException.class)
  public ResponseEntity<Map<String, String>>
  handleCustomBadRequestException(CustomBadRequestException ex) {
    Map<String, String> errorResponse = new HashMap<>();
    
    errorResponse.put("message", ex.getMessage());
    
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }
}