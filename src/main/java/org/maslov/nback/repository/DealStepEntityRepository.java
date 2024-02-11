package org.maslov.nback.repository;

import java.util.UUID;
import org.maslov.nback.model.DealStepEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealStepEntityRepository extends JpaRepository<DealStepEntity, UUID> {

}