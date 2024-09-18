package com.leonardorossi.prova2024.computer.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ComputerRequestDto(
  @NotBlank
  String name,
  
  @NotBlank
  String color,
  
  @NotNull
  Integer manufactureYear,
  
  @NotNull
  List<String> peripheralList
) {
}
