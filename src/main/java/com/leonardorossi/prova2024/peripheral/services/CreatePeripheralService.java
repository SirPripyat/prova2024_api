package com.leonardorossi.prova2024.peripheral.services;

import com.leonardorossi.prova2024.peripheral.dtos.PeripheralRequestDto;
import com.leonardorossi.prova2024.peripheral.dtos.PeripheralResponseDto;
import com.leonardorossi.prova2024.peripheral.entity.PeripheralEntity;
import com.leonardorossi.prova2024.peripheral.mapper.PeripheralMapper;
import com.leonardorossi.prova2024.peripheral.repository.PeripheralRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePeripheralService {
  private final PeripheralRepository repository;
  private final PeripheralMapper mapper;

  public PeripheralResponseDto execute(
    PeripheralRequestDto dto
  ) {
    PeripheralEntity peripheral = mapper.toEntity(dto);
    PeripheralEntity createdPeripheral = repository.save(peripheral);
    return mapper.toDto(createdPeripheral);
  }
}
