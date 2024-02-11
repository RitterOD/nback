package org.maslov.nback.repository;

import java.util.UUID;
import org.maslov.nback.model.DealAbcEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealAbcEntityRepository extends JpaRepository<DealAbcEntity, UUID> {

}