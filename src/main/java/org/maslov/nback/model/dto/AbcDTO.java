package org.maslov.nback.model.dto;

import jakarta.persistence.Column;

import java.util.UUID;

public class AbcDTO {

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private UUID id;

    private String name;


    private String elements;

    public AbcDTO(UUID id, String name, String elements) {
        this.id = id;
        this.name = name;
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElements() {
        return elements;
    }

    public void setElements(String elements) {
        this.elements = elements;
    }
}
