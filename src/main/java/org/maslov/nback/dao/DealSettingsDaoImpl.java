package org.maslov.nback.dao;

import org.maslov.nback.model.DealSettingsEntity;
import org.maslov.nback.repository.DealSettingsEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DealSettingsDaoImpl implements DealSettingsDao {

    private DealSettingsEntityRepository dealSettingsEntityRepository;

    public DealSettingsDaoImpl(DealSettingsEntityRepository dealSettingsEntityRepository) {
        this.dealSettingsEntityRepository = dealSettingsEntityRepository;
    }

    @Override
    public List<DealSettingsEntity> findAll() {
        return dealSettingsEntityRepository.findAll();
    }

    @Override
    public DealSettingsEntity save(DealSettingsEntity dealSettingsEntity) {
        return dealSettingsEntityRepository.save(dealSettingsEntity);
    }

    @Override
    public Optional<DealSettingsEntity> findById(UUID id) {
        return dealSettingsEntityRepository.findById(id);
    }
}
