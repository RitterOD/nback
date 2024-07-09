package org.maslov.nback.service;

import org.maslov.nback.dao.DealSettingsDao;
import org.maslov.nback.model.DealSettingsEntity;
import org.maslov.nback.model.dto.DealSettingsRequestDTO;
import org.maslov.nback.model.dto.DealSettingsResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DealSettingsImpl implements DealSettingsService {

    private final DealSettingsDao dealSettingsDao;


    // TODO Refactor mapper
    protected DealSettingsResponseDTO map(DealSettingsEntity entity) {
        DealSettingsResponseDTO dealSettingsResponseDTO = new DealSettingsResponseDTO();
        dealSettingsResponseDTO.setId(entity.getId());
        dealSettingsResponseDTO.setStepLength(entity.getStepLength());
        dealSettingsResponseDTO.setDealAbcEntityId(entity.getDealAbcEntity().getId());
        dealSettingsResponseDTO.setDealType(entity.getDealType());
        return dealSettingsResponseDTO;
    }

    public DealSettingsImpl(DealSettingsDao dealSettingsDao) {
        this.dealSettingsDao = dealSettingsDao;
    }

    @Override
    public List<DealSettingsResponseDTO> getAll() {
        return dealSettingsDao.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    @Override
    public Optional<DealSettingsResponseDTO> get(UUID id) {
        return dealSettingsDao.findById(id).map(this::map);
    }

    @Override
    public DealSettingsResponseDTO create(DealSettingsRequestDTO abcDTO) {
        return null;
    }
}
