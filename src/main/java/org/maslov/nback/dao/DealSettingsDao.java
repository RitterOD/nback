package org.maslov.nback.dao;

import org.maslov.nback.model.DealSettingsEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DealSettingsDao {

  List<DealSettingsEntity> findAll();
  DealSettingsEntity save(DealSettingsEntity dealSettingsEntity);

  Optional<DealSettingsEntity> findById(UUID id);
}
