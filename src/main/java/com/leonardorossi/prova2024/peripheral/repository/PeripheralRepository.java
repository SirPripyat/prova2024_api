package com.leonardorossi.prova2024.peripheral.repository;

import com.leonardorossi.prova2024.peripheral.entity.PeripheralEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeripheralRepository extends JpaRepository<PeripheralEntity, Long> {
  List<PeripheralEntity> findAllByComputerEntityId(Long computerId);

  PeripheralEntity findOneById(Long id);
}
