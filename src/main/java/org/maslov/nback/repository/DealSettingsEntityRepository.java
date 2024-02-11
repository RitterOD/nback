package org.maslov.nback.repository;

import java.util.UUID;
import org.maslov.nback.model.DealSettingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealSettingsEntityRepository extends JpaRepository<DealSettingsEntity, UUID> {

}