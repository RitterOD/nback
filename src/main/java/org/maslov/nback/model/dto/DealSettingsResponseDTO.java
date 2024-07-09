package org.maslov.nback.model.dto;

import jakarta.persistence.*;
import org.maslov.nback.model.DealAbcEntity;
import org.maslov.nback.model.DealEntity;

import java.util.List;
import java.util.UUID;

public class DealSettingsResponseDTO {

    private UUID id;

    private Long stepLength;

    private UUID dealAbcEntityId;

    private Double dealProbability;

    private Integer dealType;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getStepLength() {
        return stepLength;
    }

    public void setStepLength(Long stepLength) {
        this.stepLength = stepLength;
    }

    public UUID getDealAbcEntityId() {
        return dealAbcEntityId;
    }

    public void setDealAbcEntityId(UUID dealAbcEntityId) {
        this.dealAbcEntityId = dealAbcEntityId;
    }

    public Double getDealProbability() {
        return dealProbability;
    }

    public void setDealProbability(Double dealProbability) {
        this.dealProbability = dealProbability;
    }

    public Integer getDealType() {
        return dealType;
    }

    public void setDealType(Integer dealType) {
        this.dealType = dealType;
    }
}
