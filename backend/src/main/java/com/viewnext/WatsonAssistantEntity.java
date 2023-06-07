package com.viewnext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Representa una entidad devuelta por el servicio de Watson Assistant.
 * Una entidad es un objeto que representa información específica dentro de un mensaje.
 * Por ejemplo, en la oración "Quiero reservar una habitación para dos personas", 
 * la entidad puede ser "personas" con el valor "dos".
 * La anotación @JsonIgnoreProperties indica que las propiedades desconocidas deben ser ignoradas.
 * Esto es útil cuando se reciben respuestas de Watson Assistant que contienen propiedades desconocidas.
 * En este caso, las propiedades desconocidas se ignoran y no se produce una excepción.
 * Esto es necesario porque Watson Assistant devuelve propiedades desconocidas en algunas respuestas.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WatsonAssistantEntity {
    private String entity;
    private String value;

    /**
     * Getters y setters.
     * @return la propiedad correspondiente.
     * @param la propiedad correspondiente.
     */
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

