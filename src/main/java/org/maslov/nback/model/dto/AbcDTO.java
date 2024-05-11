package org.maslov.nback.model.dto;

import jakarta.persistence.Column;

public class AbcDTO {


    private String name;


    private String elements;

    public AbcDTO(String name, String elements) {
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
