package com.leonardorossi.prova2024.computer.services;

import com.leonardorossi.prova2024.computer.dtos.ComputerRequestDto;
import com.leonardorossi.prova2024.computer.dtos.ComputerResponseDto;
import com.leonardorossi.prova2024.computer.entity.ComputerEntity;
import com.leonardorossi.prova2024.computer.mapper.ComputerMapper;
import com.leonardorossi.prova2024.computer.repository.ComputerRepository;
import com.leonardorossi.prova2024.peripheral.dtos.PeripheralRequestDto;
import com.leonardorossi.prova2024.peripheral.dtos.PeripheralResponseDto;
import com.leonardorossi.prova2024.peripheral.services.CreatePeripheralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateComputerService {
  private final ComputerRepository repository;
  private final ComputerMapper mapper;
  
  private final CreatePeripheralService createPeripheralService;
  
  public ComputerResponseDto execute(
    ComputerRequestDto dto
  ) {
    ComputerEntity entity = mapper.toEntity(dto);
    ComputerEntity createdComputer = repository.save(entity);
    
    List<PeripheralRequestDto> peripheralList = buildPeripheralRequestDto(
      createdComputer.getId(),
      dto.peripheralList()
    );
    
    List<PeripheralResponseDto> peripheralResponseList =
      peripheralList.stream().map(createPeripheralService::execute).toList();
    
    return mapper.toDto(createdComputer, peripheralResponseList);
  }
  
  private List<PeripheralRequestDto> buildPeripheralRequestDto(
    Long idComputer,
    List<String> listPeripheral
  ) {
    return listPeripheral.stream().map((peripheral) -> PeripheralRequestDto.builder()
      .idComputer(idComputer)
      .name(peripheral)
      .build()).toList();
  }
  
}
