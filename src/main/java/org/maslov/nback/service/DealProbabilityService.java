package org.maslov.nback.service;

import org.maslov.nback.model.dto.AbcDTO;
import org.maslov.nback.model.dto.ProbabilityDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DealProbabilityService {


    List<ProbabilityDTO> getAll();

    Optional<ProbabilityDTO> get(UUID id);

    ProbabilityDTO create(ProbabilityDTO abcDTO);
}
