package org.maslov.nback.repository;

import java.util.UUID;
import org.maslov.nback.model.StepLengthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepLengthEntityRepository extends JpaRepository<StepLengthEntity, UUID> {

}