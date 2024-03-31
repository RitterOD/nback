package org.maslov.nback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "game")
public class GameEntity {

  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "deal_id")
  private DealEntity dealEntity;

  @OneToMany(mappedBy = "game")
  private List<GameEventEntity> gameEventEntities;


  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public DealEntity getDealEntity() {
    return dealEntity;
  }

  public void setDealEntity(DealEntity dealEntity) {
    this.dealEntity = dealEntity;
  }

  public List<GameEventEntity> getGameEventEntities() {
    return gameEventEntities;
  }

  public void setGameEventEntities(List<GameEventEntity> gameEventEntities) {
    this.gameEventEntities = gameEventEntities;
  }
}