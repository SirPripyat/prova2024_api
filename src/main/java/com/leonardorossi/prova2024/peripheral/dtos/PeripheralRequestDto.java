package com.leonardorossi.prova2024.peripheral.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record PeripheralRequestDto(
  @NotNull
  Long idComputer,
  
  @NotBlank
  String name
) {
}
