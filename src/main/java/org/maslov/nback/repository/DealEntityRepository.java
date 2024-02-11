package org.maslov.nback.repository;

import java.util.UUID;
import org.maslov.nback.model.DealEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealEntityRepository extends JpaRepository<DealEntity, UUID> {

}