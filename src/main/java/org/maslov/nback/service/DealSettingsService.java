package org.maslov.nback.service;

import org.maslov.nback.model.dto.AbcDTO;
import org.maslov.nback.model.dto.DealSettingsRequestDTO;
import org.maslov.nback.model.dto.DealSettingsResponseDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DealSettingsService {


    List<DealSettingsResponseDTO> getAll();

    Optional<DealSettingsResponseDTO> get(UUID id);

    DealSettingsResponseDTO create(DealSettingsRequestDTO abcDTO);
}
