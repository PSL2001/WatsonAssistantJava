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
     * Devuelve el nombre de la entidad.
     * @return Nombre de la entidad.
     */
    public String getEntity() {
        return entity;
    }
    /**
     * Establece el nombre de la entidad.
     * @param entity Nombre de la entidad.
     */
    public void setEntity(String entity) {
        this.entity = entity;
    }
    /**
     * Devuelve el valor de la entidad.
     * @return Valor de la entidad.
     */
    public String getValue() {
        return value;
    }
    /**
     * Establece el valor de la entidad.
     * @param value Valor de la entidad.
     */
    public void setValue(String value) {
        this.value = value;
    }
}

