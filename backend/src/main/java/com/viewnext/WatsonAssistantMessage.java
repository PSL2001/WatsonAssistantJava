package com.viewnext;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class WatsonAssistantMessage {
    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("intents")
    private List<WatsonAssistantIntent> intents;

    @JsonProperty("entities")
    private List<WatsonAssistantEntity> entities;

    @JsonProperty("generic")
    private List<WatsonAssistantGeneric> generic;

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



