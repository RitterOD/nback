package org.maslov.nback.service;

import org.maslov.nback.model.dto.ProbabilityDTO;
import org.maslov.nback.repository.DealProbabilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DealProbabilityServiceImpl implements DealProbabilityService{


    private DealProbabilityRepository dealProbabilityRepository;

    public DealProbabilityServiceImpl(DealProbabilityRepository dealProbabilityRepository) {
        this.dealProbabilityRepository = dealProbabilityRepository;
    }

    @Override
    public List<ProbabilityDTO> getAll() {
        return null;
    }

    @Override
    public Optional<ProbabilityDTO> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public ProbabilityDTO create(ProbabilityDTO abcDTO) {
        return null;
    }
}
