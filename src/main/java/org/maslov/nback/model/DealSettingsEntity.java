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
@Table(name = "deal_settings_entity")
public class DealSettingsEntity {

  @Id @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;



  @OneToMany(mappedBy = "dealSettingsEntity")
  private List<DealEntity> dealEntities;


  @ManyToOne
  @JoinColumn(name = "step_length_entity_id", nullable = false)
  private StepLengthEntity stepLengthEntity;

  @ManyToOne
  @JoinColumn(name = "deal_abc_entity_id", nullable = false)
  private DealAbcEntity dealAbcEntity;



  @ManyToOne
  @JoinColumn(name="insert_probability_id", nullable = false)
  private DealProbabilityEntity dealProbabilityEntity;

  @Column(name="deal_type")
  @Enumerated(value = EnumType.STRING)
  private DealType dealType;



  public StepLengthEntity getStepLengthEntity() {
    return stepLengthEntity;
  }

  public DealProbabilityEntity getDealProbabilityEntity() {
    return dealProbabilityEntity;
  }

  public void setDealProbabilityEntity(DealProbabilityEntity dealProbabilityEntity) {
    this.dealProbabilityEntity = dealProbabilityEntity;
  }

  public void setStepLengthEntity(StepLengthEntity stepLengthEntity) {
    this.stepLengthEntity = stepLengthEntity;
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