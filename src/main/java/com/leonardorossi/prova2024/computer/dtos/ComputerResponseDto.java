package com.leonardorossi.prova2024.computer.dtos;

import com.leonardorossi.prova2024.peripheral.dtos.PeripheralResponseDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record ComputerResponseDto(
  @NotBlank
  Long id,
  
  @NotBlank
  String name,
  
  @NotBlank
  String color,
  
  @NotNull
  Integer manufactureYear,
  
  @NotNull
  List<PeripheralResponseDto> peripheralList
) {
}
