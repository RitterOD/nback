package org.maslov.nback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "deal_settings")
public class DealSettingsEntity {

  @Id @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;



  @OneToMany(mappedBy = "dealSettingsEntity")
  private List<DealEntity> dealEntities;


  public Long getStepLength() {
    return stepLength;
  }

  public void setStepLength(Long stepLength) {
    this.stepLength = stepLength;
  }

  @Column(name="step_length", nullable = false)
  private Long stepLength;

  @ManyToOne
  @JoinColumn(name = "deal_abc_id", nullable = false)
  private DealAbcEntity dealAbcEntity;




  @Column(name="deal_probability")
  private Double dealProbability;

  @Column(name="deal_type", nullable = false)
  private Integer dealType;


  public Integer getDealType() {
    return dealType;
  }

  public void setDealType(Integer dealType) {
    this.dealType = dealType;
  }

  public Double getDealProbability() {
    return dealProbability;
  }

  public void setDealProbability(Double dealProbability) {
    this.dealProbability = dealProbability;
  }


  public DealAbcEntity getDealAbcEntity() {
    return dealAbcEntity;
  }

  public void setDealAbcEntity(DealAbcEntity dealAbcEntity) {
    this.dealAbcEntity = dealAbcEntity;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public List<DealEntity> getDealEntities() {
    return dealEntities;
  }

  public void setDealEntities(List<DealEntity> dealEntities) {
    this.dealEntities = dealEntities;
  }
}