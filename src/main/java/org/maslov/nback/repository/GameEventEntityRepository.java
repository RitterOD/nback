package org.maslov.nback.repository;

import java.util.UUID;
import org.maslov.nback.model.GameEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameEventEntityRepository extends JpaRepository<GameEventEntity, UUID> {

}