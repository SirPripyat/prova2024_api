package com.leonardorossi.prova2024.computer.services;

import com.leonardorossi.prova2024.computer.entity.ComputerEntity;
import com.leonardorossi.prova2024.computer.repository.ComputerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllComputerService {
  private final ComputerRepository repository;
  
  public List<ComputerEntity> execute() {
    return repository.findAll();
  }
}
