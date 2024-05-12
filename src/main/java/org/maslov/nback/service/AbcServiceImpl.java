package org.maslov.nback.service;

import org.maslov.nback.model.DealAbcEntity;
import org.maslov.nback.model.dto.AbcDTO;
import org.maslov.nback.repository.DealAbcEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AbcServiceImpl implements AbcService{

    private DealAbcEntityRepository dealAbcEntityRepository;

    public AbcServiceImpl(DealAbcEntityRepository dealAbcEntityRepository) {
        this.dealAbcEntityRepository = dealAbcEntityRepository;
    }

    @Override
    public List<AbcDTO> getAll() {
        return dealAbcEntityRepository.findAll().stream().map(e -> new AbcDTO(e.getId(), e.getName(), e.getElements())).collect(Collectors.toList());
    }

    @Override
    public Optional<AbcDTO> get(UUID id) {
        return dealAbcEntityRepository.findById(id).map(e -> new AbcDTO(e.getId(), e.getName(), e.getElements()));
    }

    @Override
    public AbcDTO create(AbcDTO abcDTO) {
        DealAbcEntity abcEntity = new DealAbcEntity();
        abcEntity.setName(abcDTO.getName());
        // TODO fix validation
        abcEntity.setElements(abcDTO.getElements());
        abcEntity = dealAbcEntityRepository.save(abcEntity);
        return new AbcDTO(abcEntity.getId(), abcDTO.getName(), abcDTO.getElements());

    }
}
