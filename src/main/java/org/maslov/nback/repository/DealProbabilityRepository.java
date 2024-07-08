package org.maslov.nback.repository;

import org.maslov.nback.model.DealProbabilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DealProbabilityRepository extends JpaRepository<DealProbabilityEntity, UUID> {
}
