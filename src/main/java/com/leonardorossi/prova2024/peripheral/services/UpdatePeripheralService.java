package com.leonardorossi.prova2024.peripheral.services;

import com.leonardorossi.prova2024.peripheral.dtos.PeripheralResponseDto;
import com.leonardorossi.prova2024.peripheral.dtos.PeripheralUpdateDto;
import com.leonardorossi.prova2024.peripheral.entity.PeripheralEntity;
import com.leonardorossi.prova2024.peripheral.mapper.PeripheralMapper;
import com.leonardorossi.prova2024.peripheral.repository.PeripheralRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePeripheralService {
  private final PeripheralRepository repository;
  private final PeripheralMapper mapper;
  
  public PeripheralResponseDto execute(
    Long id,
    PeripheralUpdateDto dto
  ) {
    PeripheralEntity foundPeripheral = repository.findOneById(id);
    updateFields(foundPeripheral, dto);
    PeripheralEntity createdPeripheral = repository.save(foundPeripheral);
    return mapper.toDto(createdPeripheral);
  }
  
  private void updateFields(
    PeripheralEntity foundPeripheral,
    PeripheralUpdateDto dto
  ) {
    if (dto.name() != null) {
      foundPeripheral.setName(dto.name());
    }
  }
}
