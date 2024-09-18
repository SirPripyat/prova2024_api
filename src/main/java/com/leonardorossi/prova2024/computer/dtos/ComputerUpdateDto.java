package com.leonardorossi.prova2024.computer.dtos;

import com.leonardorossi.prova2024.peripheral.dtos.PeripheralUpdateDto;
import lombok.Builder;

import java.util.List;

@Builder
public record ComputerUpdateDto(
  String name,
  
  String color,
  
  Integer manufactureYear,
  
  List<PeripheralUpdateDto> peripheralList
) {
}
