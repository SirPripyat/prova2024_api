package com.leonardorossi.prova2024.computer;

import com.leonardorossi.prova2024.computer.dtos.ComputerRequestDto;
import com.leonardorossi.prova2024.computer.dtos.ComputerUpdateDto;
import com.leonardorossi.prova2024.computer.entity.ComputerEntity;
import com.leonardorossi.prova2024.computer.services.*;
import com.leonardorossi.prova2024.computer.dtos.ComputerResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computers")
@RequiredArgsConstructor
@Transactional
public class ComputerController {
  
  private final CreateComputerService create;
  private final FindOneComputerService findOne;
  private final UpdateComputerService update;
  private final DeleteComputerService delete;
  private final FindAllComputerService findAll;
  
  @PostMapping
  public ResponseEntity<ComputerResponseDto> create(
    @Valid @RequestBody ComputerRequestDto dto
  ) {
    ComputerResponseDto createdComputer = create.execute(dto);
    return ResponseEntity.ok(createdComputer);
  }
  
  @GetMapping
  public ResponseEntity<List<ComputerEntity>> findAll() {
    return ResponseEntity.ok(findAll.execute());
  }
  
  @GetMapping("{id}")
  public ResponseEntity<ComputerResponseDto> findOne(
    @PathVariable Long id
  ) {
    return ResponseEntity.ok(findOne.byId(id));
  }
  
  @PutMapping("{id}")
  public ResponseEntity<ComputerResponseDto> update(
    @PathVariable Long id,
    @RequestBody ComputerUpdateDto dto
  ) {
    return ResponseEntity.ok(update.execute(id, dto));
  }
  
  @DeleteMapping("{id}")
  public ResponseEntity delete(@PathVariable Long id) {
    delete.execute(id);
    return ResponseEntity.ok().build();
  }
}
