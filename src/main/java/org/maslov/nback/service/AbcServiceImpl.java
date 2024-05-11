package org.maslov.nback.service;

import org.maslov.nback.model.dto.AbcDTO;
import org.maslov.nback.repository.DealAbcEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbcServiceImpl implements AbcService{

    private DealAbcEntityRepository dealAbcEntityRepository;

    public AbcServiceImpl(DealAbcEntityRepository dealAbcEntityRepository) {
        this.dealAbcEntityRepository = dealAbcEntityRepository;
    }

    @Override
    public List<AbcDTO> getAll() {
        return dealAbcEntityRepository.findAll().stream().map(e -> new AbcDTO(e.getName(), e.getElements())).collect(Collectors.toList());
    }
}
