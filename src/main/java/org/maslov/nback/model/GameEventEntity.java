package org.maslov.nback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "game_event_entity")
public class GameEventEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "event_type")
  @Enumerated(EnumType.STRING)
  private GameEventType gameEventType;


  @Column(name = "time_stamp")
  private Long timeStamp;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public GameEventType getGameEventType() {
    return gameEventType;
  }

  public void setGameEventType(GameEventType gameEventType) {
    this.gameEventType = gameEventType;
  }
}