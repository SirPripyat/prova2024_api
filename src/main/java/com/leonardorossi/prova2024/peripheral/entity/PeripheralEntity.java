package com.leonardorossi.prova2024.peripheral.entity;

import com.leonardorossi.prova2024.computer.entity.ComputerEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PERIPHERAL")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PeripheralEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_PERIPHERAL")
  private Long id;
  
  @Column(name = "NOME")
  private String name;
  
  @ManyToOne
  @JoinColumn(name = "ID_COMPUTER", nullable = false)
  private ComputerEntity computerEntity;
}
