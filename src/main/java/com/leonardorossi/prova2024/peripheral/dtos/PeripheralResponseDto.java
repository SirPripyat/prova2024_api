package com.leonardorossi.prova2024.peripheral.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record PeripheralResponseDto(
  @NotNull
  Long id,
  
  @NotBlank
  String name,
  
  @NotNull
  Long idComputer
) {
}
