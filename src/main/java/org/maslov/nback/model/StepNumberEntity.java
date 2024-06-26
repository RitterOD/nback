package org.maslov.nback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "step_number")
public class StepNumberEntity {

  @Id @GeneratedValue(strategy = GenerationType.UUID) @Column(name = "id", nullable = false)
  private UUID id;


  @Column(name="step_number")
  private Long stepNumber;

}