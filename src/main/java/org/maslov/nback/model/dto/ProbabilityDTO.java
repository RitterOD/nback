package org.maslov.nback.model.dto;

import java.util.UUID;

public class ProbabilityDTO {

    private UUID id;
    private Double probability;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }
}
