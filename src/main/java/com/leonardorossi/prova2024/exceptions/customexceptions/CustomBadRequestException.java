package com.leonardorossi.prova2024.exceptions.customexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomBadRequestException extends RuntimeException {
  public CustomBadRequestException(String message) {
    super(message);
  }
}