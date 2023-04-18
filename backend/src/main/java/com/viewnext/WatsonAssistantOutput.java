package com.viewnext;

import java.util.List;
/*
 * Representa la respuesta del servicio de Watson Assistant.
 * Una respuesta contiene información sobre las intenciones, las entidades y las respuestas genéricas.
 * Por ejemplo, en la oración "Quiero reservar una habitación para dos personas",
 * la respuesta puede contener la intención "reservar", la entidad "personas" con el valor "dos" y la respuesta "¿Cuándo quieres reservar la habitación?".
 */
public class WatsonAssistantOutput {
    private List<WatsonAssistantGeneric> generic;
    private List<WatsonAssistantIntent> intents;
    private List<WatsonAssistantEntity> entities;

    // Constructores, getters y setters
    public WatsonAssistantOutput() {
    }
    
    public WatsonAssistantOutput(List<WatsonAssistantGeneric> generic, List<WatsonAssistantIntent> intents, List<WatsonAssistantEntity> entities) {
        this.generic = generic;
        this.intents = intents;
        this.entities = entities;
    }

    public List<WatsonAssistantGeneric> getGeneric() {
        return generic;
    }

    public void setGeneric(List<WatsonAssistantGeneric> generic) {
        this.generic = generic;
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
}

