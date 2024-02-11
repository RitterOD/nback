package org.maslov.nback.repository;

import java.util.UUID;
import org.maslov.nback.model.StepNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepNumberEntityRepository extends JpaRepository<StepNumberEntity, UUID> {

}