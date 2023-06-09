package com.viewnext;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Representa el mensaje devuelto por el servicio de Watson Assistant.
 * Un mensaje es un objeto que contiene información sobre la intención, las entidades y la respuesta del usuario.
 * Por ejemplo, en la oración "Quiero reservar una habitación para dos personas",
 * el mensaje puede contener la intención "reservar", la entidad "personas" con el valor "dos" y la respuesta "¿Cuándo quieres reservar la habitación?".
 */
public class WatsonAssistantMessage {
    /*  
     * Identificador del usuario que envía el mensaje.
     * Este identificador se utiliza para mantener la conversación con el usuario.
     */
    @JsonProperty("user_id")
    private String userId;

    /*  
     * Lista de intenciones devueltas por el servicio de Watson Assistant.
     * Puedes mirar la clase WatsonAssistantIntent para ver cómo se representa una intención.
     */
    @JsonProperty("intents")
    private List<WatsonAssistantIntent> intents;

    /*  
     * Lista de entidades devueltas por el servicio de Watson Assistant.
     * Puedes mirar la clase WatsonAssistantEntity para ver cómo se representa una entidad.
     */
    @JsonProperty("entities")
    private List<WatsonAssistantEntity> entities;

    /*  
     * Lista de respuestas genéricas devueltas por el servicio de Watson Assistant.
     * Puedes mirar la clase WatsonAssistantGeneric para ver cómo se representa una respuesta genérica.
     */
    @JsonProperty("generic")
    private List<WatsonAssistantGeneric> generic;

    /*  
     * Objeto que contiene información sobre la respuesta del usuario.
     * Puedes mirar la clase WatsonAssistantOutput para ver cómo se representa la respuesta del usuario.
     */
    @JsonProperty("output")
    private WatsonAssistantOutput output;

    // Constructores, getters y setters
    /**
     * Constructor por defecto.
     */
    public WatsonAssistantMessage() {
    }
    /**
     * Constructor con parámetros.
     * @param userId Identificador del usuario.
     * @param intents Lista de intenciones.
     * @param entities Lista de entidades.
     * @param generic Lista de respuestas genéricas.
     * @param output Respuesta del asistente.
     */
    public WatsonAssistantMessage(String userId, List<WatsonAssistantIntent> intents, List<WatsonAssistantEntity> entities, List<WatsonAssistantGeneric> generic, WatsonAssistantOutput output) {
        this.userId = userId;
        this.intents = intents;
        this.entities = entities;
        this.generic = generic;
        this.output = output;
    }
    /**
     * Devuelve el identificador del usuario que envía el mensaje.
     * @return userId
     */
    public String getUserId() {
        return userId;
    }
    /**
     * Establece el identificador del usuario que envía el mensaje.
     * @param userId Identificador del usuario.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    /**
     * Devuelve la lista de intenciones devueltas por el servicio de Watson Assistant.
     * @return intents
     */
    public List<WatsonAssistantIntent> getIntents() {
        return intents;
    }
    /**
     * Establece la lista de intenciones devueltas por el servicio de Watson Assistant.
     * @param intents Lista de intenciones.
     */
    public void setIntents(List<WatsonAssistantIntent> intents) {
        this.intents = intents;
    }
    /**
     * Devuelve la lista de entidades devueltas por el servicio de Watson Assistant.
     * @return entities
     */
    public List<WatsonAssistantEntity> getEntities() {
        return entities;
    }
    /**
     * Establece la lista de entidades devueltas por el servicio de Watson Assistant.
     * @param entities Lista de entidades.
     */
    public void setEntities(List<WatsonAssistantEntity> entities) {
        this.entities = entities;
    }
    /**
     * Devuelve la lista de respuestas genéricas devueltas por el servicio de Watson Assistant.
     * @return generic
     */
    public List<WatsonAssistantGeneric> getGeneric() {
        return generic;
    }
    /**
     * Establece la lista de respuestas genéricas devueltas por el servicio de Watson Assistant.
     * @param generic Lista de respuestas genéricas.
     */
    public void setGeneric(List<WatsonAssistantGeneric> generic) {
        this.generic = generic;
    }
    /**
     * Devuelve el objeto que contiene información sobre la respuesta del usuario.
     * @return output La respuesta del asistente.
     */
    public WatsonAssistantOutput getOutput() {
        return output;
    }
    /**
     * Establece el objeto que contiene información sobre la respuesta del usuario.
     * @param output La respuesta del asistente.
     */
    public void setOutput(WatsonAssistantOutput output) {
        this.output = output;
    }
    /**
     * Devuelve una representación del objeto en formato String.
     * @return String
     */
    @Override
    public String toString() {
        return "WatsonAssistantMessage{" + "userId=" + userId + ", intents=" + intents + ", entities=" + entities + ", generic=" + generic + ", output=" + output + '}';
    }
}



