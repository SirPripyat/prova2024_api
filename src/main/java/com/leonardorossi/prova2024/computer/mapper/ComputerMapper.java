package com.leonardorossi.prova2024.computer.mapper;

import com.leonardorossi.prova2024.computer.dtos.ComputerRequestDto;
import com.leonardorossi.prova2024.computer.dtos.ComputerResponseDto;
import com.leonardorossi.prova2024.computer.entity.ComputerEntity;
import com.leonardorossi.prova2024.peripheral.dtos.PeripheralResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComputerMapper {
  
  public ComputerEntity toEntity(ComputerRequestDto dto) {
    return ComputerEntity.builder()
      .name(dto.name())
      .color(dto.color())
      .manufactureYear(dto.manufactureYear())
      .build();
  }
  
  public ComputerEntity toEntity(ComputerResponseDto dto) {
    return ComputerEntity.builder()
      .id(dto.id())
      .name(dto.name())
      .color(dto.color())
      .manufactureYear(dto.manufactureYear())
      .build();
  }
  
  public ComputerResponseDto toDto(
    ComputerEntity entity
  ) {
    return ComputerResponseDto.builder()
      .id(entity.getId())
      .name(entity.getName())
      .color(entity.getColor())
      .manufactureYear(entity.getManufactureYear())
      .build();
  }
  
  public ComputerResponseDto toDto(
    ComputerEntity entity,
    List<PeripheralResponseDto> peripheralList
  ) {
    return ComputerResponseDto.builder()
      .id(entity.getId())
      .name(entity.getName())
      .color(entity.getColor())
      .manufactureYear(entity.getManufactureYear())
      .peripheralList(peripheralList)
      .build();
  }
  
}
