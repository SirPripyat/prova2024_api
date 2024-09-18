package com.leonardorossi.prova2024.computer.services;

import com.leonardorossi.prova2024.computer.dtos.ComputerResponseDto;
import com.leonardorossi.prova2024.computer.entity.ComputerEntity;
import com.leonardorossi.prova2024.computer.mapper.ComputerMapper;
import com.leonardorossi.prova2024.computer.repository.ComputerRepository;
import com.leonardorossi.prova2024.exceptions.customexceptions.CustomBadRequestException;
import com.leonardorossi.prova2024.messages.computer.exceptions.ComputerExceptionMessages;
import com.leonardorossi.prova2024.peripheral.dtos.PeripheralResponseDto;
import com.leonardorossi.prova2024.peripheral.entity.PeripheralEntity;
import com.leonardorossi.prova2024.peripheral.services.FindAllPeripheralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindOneComputerService {
  private final ComputerRepository repository;
  private final ComputerMapper mapper;
  
  private final FindAllPeripheralService findAllPeripheralService;
  
  public ComputerResponseDto byId(Long id) {
    ComputerEntity foundComputer = repository.findById(id)
      .orElseThrow(() -> this.computerNotFound(id));
    
    List<PeripheralResponseDto> peripheralList = findAllPeripheralService.byIdComputer(id);
    
    return mapper.toDto(foundComputer, peripheralList);
  }
  
  private CustomBadRequestException computerNotFound(Long id) {
    return new CustomBadRequestException(
      String.format(ComputerExceptionMessages.NOT_FOUND, id)
    );
  }
}
