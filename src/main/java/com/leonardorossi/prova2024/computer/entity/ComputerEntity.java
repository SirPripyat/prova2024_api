package com.leonardorossi.prova2024.computer.entity;

import com.leonardorossi.prova2024.peripheral.entity.PeripheralEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "COMPUTER")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComputerEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_COMPUTER")
  private Long id;
  
  @Column(name = "NOME")
  private String name;
  
  @Column(name = "COLOR")
  private String color;
  
  @Column(name = "MANUFACTURE_DATE")
  private Integer manufactureYear;
  
  @OneToMany(mappedBy = "computerEntity", cascade = CascadeType.ALL)
  private List<PeripheralEntity> peripheralEntityList;
}
