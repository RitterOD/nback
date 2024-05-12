package org.maslov.nback.service;

import org.maslov.nback.model.dto.AbcDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AbcService {

    List<AbcDTO> getAll();

    Optional<AbcDTO> get(UUID id);

    AbcDTO create(AbcDTO abcDTO);
}
