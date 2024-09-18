package com.leonardorossi.prova2024.peripheral.dtos;

import lombok.Builder;

@Builder
public record PeripheralUpdateDto(
  Long id,
  
  String name
) {
}
