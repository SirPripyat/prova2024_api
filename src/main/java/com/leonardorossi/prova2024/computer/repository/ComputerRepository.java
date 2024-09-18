package com.leonardorossi.prova2024.computer.repository;

import com.leonardorossi.prova2024.computer.entity.ComputerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComputerRepository extends JpaRepository<ComputerEntity, Long> {
  Optional<ComputerEntity> findOneById(Integer id);
  
  boolean existsById(Integer id);
  
  void deleteById(Integer id);
}
