package com.leonardorossi.prova2024.peripheral.mapper;

import com.leonardorossi.prova2024.computer.entity.ComputerEntity;
import com.leonardorossi.prova2024.peripheral.dtos.PeripheralRequestDto;
import com.leonardorossi.prova2024.peripheral.dtos.PeripheralResponseDto;
import com.leonardorossi.prova2024.peripheral.entity.PeripheralEntity;
import org.springframework.stereotype.Component;

@Component
public class PeripheralMapper {
  
  public PeripheralEntity toEntity(PeripheralRequestDto dto) {
    ComputerEntity computerEntity = ComputerEntity.builder()
      .id(dto.idComputer())
      .build();
    
    return PeripheralEntity.builder()
      .name(dto.name())
      .computerEntity(computerEntity)
      .build();
  }
  
  public PeripheralResponseDto toDto(PeripheralEntity entity) {
    return PeripheralResponseDto.builder()
      .id(entity.getId())
      .name(entity.getName())
      .idComputer(entity.getComputerEntity().getId())
      .build();
  }
  
}
