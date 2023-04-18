package com.viewnext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Representa una entidad devuelta por el servicio de Watson Assistant.
 * Una entidad es un objeto que representa información específica dentro de un mensaje.
 * Por ejemplo, en la oración "Quiero reservar una habitación para dos personas", 
 * la entidad puede ser "personas" con el valor "dos".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WatsonAssistantEntity {
    private String entity;
    private String value;

    // Getters and setters
    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

