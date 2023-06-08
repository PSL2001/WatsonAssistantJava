package com.viewnext;

import java.util.List;
/*
 * Representa la respuesta del servicio de Watson Assistant.
 * Una respuesta contiene información sobre las intenciones, las entidades y las respuestas genéricas.
 * Por ejemplo, en la oración "Quiero reservar una habitación para dos personas",
 * la respuesta puede contener la intención "reservar", la entidad "personas" con el valor "dos" y la respuesta "¿Cuándo quieres reservar la habitación?".
 */
public class WatsonAssistantOutput {
    /**
     * Generic es una lista de respuestas genéricas.
     * Una respuesta genérica puede ser un texto, una imagen, un vídeo, etc.
     * Por ejemplo, si la intención es "reservar" y la entidad es "personas" con el valor "dos",
     * la respuesta genérica puede ser "¿Cuándo quieres reservar la habitación para dos personas?".
     */
    private List<WatsonAssistantGeneric> generic;
    /**
     * Intents es una lista de intenciones.
     * Una intención es la acción que el usuario quiere realizar.
     * Por ejemplo, en la oración "Quiero reservar una habitación para dos personas",
     * la intención es "reservar".
     */
    private List<WatsonAssistantIntent> intents;
    /**
     * Entities es una lista de entidades.
     * Una entidad es un objeto que se extrae de la oración.
     * Por ejemplo, en la oración "Quiero reservar una habitación para dos personas",
     * la entidad es "personas" con el valor "dos".
     */
    private List<WatsonAssistantEntity> entities;

    // Constructores, getters y setters
    /**
     * Constructor por defecto.
     */
    public WatsonAssistantOutput() {
    }
    /**
     * Constructor con parámetros.
     * @param generic Las respuestas genéricas.
     * @param intents Las intenciones.
     * @param entities Las entidades.
     */
    public WatsonAssistantOutput(List<WatsonAssistantGeneric> generic, List<WatsonAssistantIntent> intents, List<WatsonAssistantEntity> entities) {
        this.generic = generic;
        this.intents = intents;
        this.entities = entities;
    }
    /**
     * Devuelve la lista de respuestas genéricas.
     * @return generic Lista de respuestas genéricas.
     */
    public List<WatsonAssistantGeneric> getGeneric() {
        return generic;
    }
    /**
     * Establece la lista de respuestas genéricas.
     * @param generic Lista de respuestas genéricas.
     */
    public void setGeneric(List<WatsonAssistantGeneric> generic) {
        this.generic = generic;
    }
    /**
     * Devuelve la lista de intenciones.
     * @return intents Lista de intenciones.
     */
    public List<WatsonAssistantIntent> getIntents() {
        return intents;
    }
    /**
     * Establece la lista de intenciones.
     * @param intents Lista de intenciones.
     */
    public void setIntents(List<WatsonAssistantIntent> intents) {
        this.intents = intents;
    }
    /**
     * Devuelve la lista de entidades.
     * @return entities Lista de entidades.
     */
    public List<WatsonAssistantEntity> getEntities() {
        return entities;
    }
    /**
     * Establece la lista de entidades.
     * @param entities Lista de entidades.
     */
    public void setEntities(List<WatsonAssistantEntity> entities) {
        this.entities = entities;
    }
    /**
     * Devuelve una cadena de caracteres con los valores de los atributos.
     * @return String
     */
    @Override
    public String toString() {
        return "WatsonAssistantOutput [entities=" + entities + ", generic=" + generic + ", intents=" + intents + "]";
    }
}

