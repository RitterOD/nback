package org.maslov.nback.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "deal_probability")
public class DealProbabilityEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;




  @Column(name = "insert_probability")
  private Double insertProbability;


  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Double getInsertProbability() {
    return insertProbability;
  }

  public void setInsertProbability(Double insertProbability) {
    this.insertProbability = insertProbability;
  }
}
