package com.leonardorossi.prova2024.computer.services;

import com.leonardorossi.prova2024.computer.dtos.ComputerResponseDto;
import com.leonardorossi.prova2024.computer.dtos.ComputerUpdateDto;
import com.leonardorossi.prova2024.computer.entity.ComputerEntity;
import com.leonardorossi.prova2024.computer.mapper.ComputerMapper;
import com.leonardorossi.prova2024.computer.repository.ComputerRepository;
import com.leonardorossi.prova2024.peripheral.dtos.PeripheralResponseDto;
import com.leonardorossi.prova2024.peripheral.services.UpdatePeripheralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdateComputerService {
  private final ComputerRepository repository;
  private final ComputerMapper mapper;
  
  private final FindOneComputerService findOneComputerService;
  private final UpdatePeripheralService updatePeripheralService;
  
  public ComputerResponseDto execute(
    Long id,
    ComputerUpdateDto dto
  ) {
    ComputerResponseDto foundComputer = findOneComputerService.byId(id);
    ComputerEntity entity = mapper.toEntity(foundComputer);
    
    updateFields(entity, dto);
    
    List<PeripheralResponseDto> listPeripherals = new ArrayList<>();
    
    if (dto.peripheralList() != null) {
      listPeripherals = dto.peripheralList()
        .stream()
        .map((peripheral) -> updatePeripheralService
          .execute(peripheral.id(), peripheral))
        .toList();
    }
    
    ComputerEntity updatedComputer = repository.save(entity);
    
    return mapper.toDto(updatedComputer, listPeripherals);
  }
  
  private void updateFields(ComputerEntity foundComputer, ComputerUpdateDto computerToUpdate) {
    if (computerToUpdate.name() != null) {
      foundComputer.setName(computerToUpdate.name());
    }
    
    if (computerToUpdate.color() != null) {
      foundComputer.setColor(computerToUpdate.color());
    }
    
    if (computerToUpdate.manufactureYear() != null) {
      foundComputer.setManufactureYear(computerToUpdate.manufactureYear());
    }
  }
}
