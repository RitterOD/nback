package org.maslov.nback.repository;

import java.util.UUID;
import org.maslov.nback.model.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameEntityRepository extends JpaRepository<GameEntity, UUID> {

}