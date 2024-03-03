package org.maslov.nback.dao;

import org.maslov.nback.model.DealSettingsEntity;
import org.maslov.nback.repository.DealSettingsEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class DealSettingsDaoImpl implements DealSettingsDao{

  private DealSettingsEntityRepository dealSettingsEntityRepository;

  public DealSettingsDaoImpl(DealSettingsEntityRepository dealSettingsEntityRepository) {
    this.dealSettingsEntityRepository = dealSettingsEntityRepository;
  }

  @Override public DealSettingsEntity save(DealSettingsEntity dealSettingsEntity) {
    return dealSettingsEntityRepository.save(dealSettingsEntity);
  }
}
