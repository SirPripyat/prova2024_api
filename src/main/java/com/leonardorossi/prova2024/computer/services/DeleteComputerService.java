package com.leonardorossi.prova2024.computer.services;

import com.leonardorossi.prova2024.computer.repository.ComputerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteComputerService {
  private final ComputerRepository repository;
  
  public void execute(Long id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
    }
  }
}
