package com.leonardorossi.prova2024.peripheral.services;

import com.leonardorossi.prova2024.peripheral.dtos.PeripheralResponseDto;
import com.leonardorossi.prova2024.peripheral.entity.PeripheralEntity;
import com.leonardorossi.prova2024.peripheral.mapper.PeripheralMapper;
import com.leonardorossi.prova2024.peripheral.repository.PeripheralRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllPeripheralService {
  private final PeripheralRepository peripheralRepository;
  private final PeripheralMapper mapper;
  
  public List<PeripheralResponseDto> byIdComputer(Long idComputer) {
    List<PeripheralEntity> peripheralEntityList =
      peripheralRepository.findAllByComputerEntityId(idComputer);
  
    return peripheralEntityList.stream().map(mapper::toDto).toList();
  }
  
}
