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
    public WatsonAssistantMessage() {
    }

    public WatsonAssistantMessage(String userId, List<WatsonAssistantIntent> intents, List<WatsonAssistantEntity> entities, List<WatsonAssistantGeneric> generic, WatsonAssistantOutput output) {
        this.userId = userId;
        this.intents = intents;
        this.entities = entities;
        this.generic = generic;
        this.output = output;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<WatsonAssistantIntent> getIntents() {
        return intents;
    }

    public void setIntents(List<WatsonAssistantIntent> intents) {
        this.intents = intents;
    }

    public List<WatsonAssistantEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<WatsonAssistantEntity> entities) {
        this.entities = entities;
    }

    public List<WatsonAssistantGeneric> getGeneric() {
        return generic;
    }

    public void setGeneric(List<WatsonAssistantGeneric> generic) {
        this.generic = generic;
    }

    public WatsonAssistantOutput getOutput() {
        return output;
    }

    public void setOutput(WatsonAssistantOutput output) {
        this.output = output;
    }
}



