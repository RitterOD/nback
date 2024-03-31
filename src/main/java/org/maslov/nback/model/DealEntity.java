package org.maslov.nback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "deal")
public class DealEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;

  @ManyToOne
  @JoinColumn(name="settings_id", nullable=false)
  private DealSettingsEntity dealSettingsEntity;

  @OneToMany(mappedBy = "dealEntity")
  private List<GameEntity> gameEntities;

  @OneToMany(mappedBy = "dealEntity")
  private List<DealStepEntity> dealStepEntities;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public DealSettingsEntity getDealSettingsEntity() {
    return dealSettingsEntity;
  }

  public void setDealSettingsEntity(DealSettingsEntity dealSettingsEntity) {
    this.dealSettingsEntity = dealSettingsEntity;
  }

  public List<GameEntity> getGameEntities() {
    return gameEntities;
  }

  public void setGameEntities(List<GameEntity> gameEntities) {
    this.gameEntities = gameEntities;
  }

  public List<DealStepEntity> getDealStepEntities() {
    return dealStepEntities;
  }

  public void setDealStepEntities(List<DealStepEntity> dealStepEntities) {
    this.dealStepEntities = dealStepEntities;
  }
}